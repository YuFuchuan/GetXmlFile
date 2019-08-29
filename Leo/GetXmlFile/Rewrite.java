package Leo.GetXmlFile;

public class Rewrite {
	final static int INDENT_SPACE=2;
	
	public static String re = "";
	
	//�����������
	static void WriteIndent(int depth) {
		while(depth>1) {
			for(int i=INDENT_SPACE;i>0;i++) {
				re+=" ";
			}
			depth--;
		}
	}
	
	//��д
	public static void RewriteStringStream() {
		re="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		int node_total = GetXmlFile_v1_1Parser.i_n;
		
		//������ڵ����
		int depth_max=GetXmlFile_v1_1Parser.node_depth.get(1);
		for(int i=1;i<=node_total;i++) {
			if(GetXmlFile_v1_1Parser.node_depth.get(i)>depth_max) {
				depth_max=GetXmlFile_v1_1Parser.node_depth.get(i);
			}
		}
		
		//���ô��δ��β�ڵ������
		int node_id[]=new int[depth_max];
		for(int i=0;i<depth_max;i++) {
			node_id[i]=0;
		}
		
		for(int i=1;i<=node_total;i++) {
			WriteIndent(GetXmlFile_v1_1Parser.node_depth.get(i));
			re=re+"<"+GetXmlFile_v1_1Parser.node_name.get(i);								//�ڵ��ͷ
			
			if(GetXmlFile_v1_1Parser.node_property_first.get(i)<=GetXmlFile_v1_1Parser.node_property_final.get(i)) {
				for(int j=GetXmlFile_v1_1Parser.node_property_first.get(i);j<=GetXmlFile_v1_1Parser.node_property_final.get(i);j++) {
					re=re+" "+GetXmlFile_v1_1Parser.property_name.get(j)+"=\""+GetXmlFile_v1_1Parser.property_value.get(j)+"\"";
				}
			}
			
			re=re+">";

			//������¸��ڵ���ͬ;
			if(GetXmlFile_v1_1Parser.node_depth.get(i)==GetXmlFile_v1_1Parser.node_depth.get(i+1)) {
				re=re+GetXmlFile_v1_1Parser.node_value.get(i);								//�ڵ��ֵ
				re=re+"</"+GetXmlFile_v1_1Parser.node_name.get(i)+">\n";					//�ڵ���β
			}
			//��ȱ��¸��ڵ�С1;
			else if(GetXmlFile_v1_1Parser.node_depth.get(i)==GetXmlFile_v1_1Parser.node_depth.get(i+1)-1) {
				node_id[GetXmlFile_v1_1Parser.node_depth.get(i)-1]=i;						//��¼�ڵ�id
				re=re+"\n";
			}
			//��ȱ��¸��ڵ��;
			else if(GetXmlFile_v1_1Parser.node_depth.get(i)>GetXmlFile_v1_1Parser.node_depth.get(i+1)) {
				re=re+GetXmlFile_v1_1Parser.node_value.get(i);								//�ڵ��ֵ
				re=re+"</"+GetXmlFile_v1_1Parser.node_name.get(i)+">\n";					//�ڵ���β
				for(int j=GetXmlFile_v1_1Parser.node_depth.get(i)-2;j>GetXmlFile_v1_1Parser.node_depth.get(i+1)-2;j--) {
					WriteIndent(GetXmlFile_v1_1Parser.node_depth.get(node_id[j]));
					re=re+"</"+GetXmlFile_v1_1Parser.node_name.get(node_id[j])+">\n";		//�Բ��ּ�¼�Ľڵ���β
				}
			}
			
		}
	}
}
