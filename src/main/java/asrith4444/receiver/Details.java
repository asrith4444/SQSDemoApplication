package asrith4444.receiver;
import java.io.*;
import java.util.Scanner;
public class Details {
	static String mailID,password;
	static  {
		try {
			File f = new File("D:\\Eclipse\\SQSDemoApplication\\src\\main\\java\\asrith4444\\receiver\\details.txt");
		      Scanner s = new Scanner(f);
		      String[] data = new String[2];
		      int i=0;
		      while (s.hasNextLine()) {
		        data[i] = s.nextLine();i++;
		      }
		      s.close();
		      mailID=data[0];
		      password=data[1];
		} catch (IOException e) {
			System.out.println("File not found!");
		}    
		//return password;
	}
}