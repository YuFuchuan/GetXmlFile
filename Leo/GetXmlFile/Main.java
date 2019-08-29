package Leo.GetXmlFile;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import Leo.GetXmlFile.GetXmlFile_v1_1Lexer;
import Leo.GetXmlFile.GetXmlFile_v1_1Parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		while(true) {
			InputStream is = System.in;
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("输入文件路径及文件名:");
			String filePath = br.readLine();
			is = new FileInputStream(filePath);
			
			ANTLRInputStream input = new ANTLRInputStream(is);					//输入流转antlr输入流
			GetXmlFile_v1_1Lexer lexer = new GetXmlFile_v1_1Lexer(input);		//词法
			CommonTokenStream tokens = new CommonTokenStream(lexer);			//转token流
			GetXmlFile_v1_1Parser parser = new GetXmlFile_v1_1Parser(tokens);	//语法
			
			parser.node();							//遍历
			Rewrite.RewriteStringStream();			//重写
			
			//写入文件
			FileWriter writer;
			try {
				writer = new FileWriter(filePath);
				writer.write("");
				writer.write(Rewrite.re);
				writer.flush();
				writer.close();
				System.out.println("已更新该文件");
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
