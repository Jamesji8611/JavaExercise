package com.IOTest;
import java.io.*;

public class IOTestBufferedReaderWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;		
		
		try {
			fr = new FileReader("d:\\Test\\IOTest\\tmp999.txt");
			fw = new FileWriter("d:\\Test\\IOTest\\testDir\\tmp995.txt");
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			String s = null;
			
			while((s = br.readLine()) != null){
				bw.write(s + "\r\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			try{
				br.close();
				bw.close();
				fr.close();
				fw.close();
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
