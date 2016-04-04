package com.IOTest;
import java.io.*;

public class IOTestFileReaderWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = new char[1024];
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("d:\\Test\\IOTest\\tmp999.txt");
			fw = new FileWriter("d:\\Test\\IOTest\\testDir\\tmp994.txt");
			int n = 0;
			int i = 0;
			
			while( (n = fr.read(c)) != -1){
				System.out.println("n = " + n);
				fw.write(c,0,n);
				c = new char[1024];
				i++;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				fr.close();
				fw.close();
			} catch( Exception e){
				e.printStackTrace();
			}
			
		}
	}

}
