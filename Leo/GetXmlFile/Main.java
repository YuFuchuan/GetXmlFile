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
			
			System.out.print("�����ļ�·�����ļ���:");
			String filePath = br.readLine();
			is = new FileInputStream(filePath);
			
			ANTLRInputStream input = new ANTLRInputStream(is);					//������תantlr������
			GetXmlFile_v1_1Lexer lexer = new GetXmlFile_v1_1Lexer(input);		//�ʷ�
			CommonTokenStream tokens = new CommonTokenStream(lexer);			//תtoken��
			GetXmlFile_v1_1Parser parser = new GetXmlFile_v1_1Parser(tokens);	//�﷨
			
			parser.node();							//����
			Rewrite.RewriteStringStream();			//��д
			
			//д���ļ�
			FileWriter writer;
			try {
				writer = new FileWriter(filePath);
				writer.write("");
				writer.write(Rewrite.re);
				writer.flush();
				writer.close();
				System.out.println("�Ѹ��¸��ļ�");
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
