package Leo.GetXmlFile;

public class Rewrite {
	final static int INDENT_SPACE=2;
	
	public static String re = "";
	
	//用于添加缩进
	static void WriteIndent(int depth) {
		while(depth>1) {
			for(int i=INDENT_SPACE;i>0;i++) {
				re+=" ";
			}
			depth--;
		}
	}
	
	//重写
	public static void RewriteStringStream() {
		re="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		int node_total = GetXmlFile_v1_1Parser.i_n;
		
		//获得最大节点深度
		int depth_max=GetXmlFile_v1_1Parser.node_depth.get(1);
		for(int i=1;i<=node_total;i++) {
			if(GetXmlFile_v1_1Parser.node_depth.get(i)>depth_max) {
				depth_max=GetXmlFile_v1_1Parser.node_depth.get(i);
			}
		}
		
		//设置存放未收尾节点的数组
		int node_id[]=new int[depth_max];
		for(int i=0;i<depth_max;i++) {
			node_id[i]=0;
		}
		
		for(int i=1;i<=node_total;i++) {
			WriteIndent(GetXmlFile_v1_1Parser.node_depth.get(i));
			re=re+"<"+GetXmlFile_v1_1Parser.node_name.get(i);								//节点的头
			
			if(GetXmlFile_v1_1Parser.node_property_first.get(i)<=GetXmlFile_v1_1Parser.node_property_final.get(i)) {
				for(int j=GetXmlFile_v1_1Parser.node_property_first.get(i);j<=GetXmlFile_v1_1Parser.node_property_final.get(i);j++) {
					re=re+" "+GetXmlFile_v1_1Parser.property_name.get(j)+"=\""+GetXmlFile_v1_1Parser.property_value.get(j)+"\"";
				}
			}
			
			re=re+">";

			//深度与下个节点相同;
			if(GetXmlFile_v1_1Parser.node_depth.get(i)==GetXmlFile_v1_1Parser.node_depth.get(i+1)) {
				re=re+GetXmlFile_v1_1Parser.node_value.get(i);								//节点的值
				re=re+"</"+GetXmlFile_v1_1Parser.node_name.get(i)+">\n";					//节点收尾
			}
			//深度比下个节点小1;
			else if(GetXmlFile_v1_1Parser.node_depth.get(i)==GetXmlFile_v1_1Parser.node_depth.get(i+1)-1) {
				node_id[GetXmlFile_v1_1Parser.node_depth.get(i)-1]=i;						//记录节点id
				re=re+"\n";
			}
			//深度比下个节点大;
			else if(GetXmlFile_v1_1Parser.node_depth.get(i)>GetXmlFile_v1_1Parser.node_depth.get(i+1)) {
				re=re+GetXmlFile_v1_1Parser.node_value.get(i);								//节点的值
				re=re+"</"+GetXmlFile_v1_1Parser.node_name.get(i)+">\n";					//节点收尾
				for(int j=GetXmlFile_v1_1Parser.node_depth.get(i)-2;j>GetXmlFile_v1_1Parser.node_depth.get(i+1)-2;j--) {
					WriteIndent(GetXmlFile_v1_1Parser.node_depth.get(node_id[j]));
					re=re+"</"+GetXmlFile_v1_1Parser.node_name.get(node_id[j])+">\n";		//对部分记录的节点收尾
				}
			}
			
		}
	}
}
