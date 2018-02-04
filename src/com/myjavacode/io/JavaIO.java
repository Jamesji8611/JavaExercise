package com.myjavacode.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class JavaIO {
	private static FileReader fr = null;
	private static FileWriter fw = null;
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;
	private static InputStream is = null;
	private static OutputStream os = null;
	private static String date = null;
	
	public static void main(String[] args) throws IOException {
				
		try {
			fr = new FileReader("D:\\MyJavacode\\IOFile\\IOFile.txt");
			br = new BufferedReader(fr);
			
			String tmp =null; 
			while( (tmp= br.readLine()) != null ){
				System.out.println( tmp );
			}
			closeflie();
			
			date = new Date().toString();
			
			fw = new FileWriter("D:\\MyJavacode\\IOFile\\IOFile.txt",true);
			bw = new BufferedWriter(fw);
			//bw.write( date );
			bw.append(date+"\n");
			closeflie();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeflie();
		}
		
		
	}
	
	private static void closeflie() {
		try {
			if(br != null) {
				br.close();
			}
			if(bw != null) {
				bw.close();
			}
			if(fr != null) {
				fr.close();
			}
			if(fw != null) {
				fw.close();
			}			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
