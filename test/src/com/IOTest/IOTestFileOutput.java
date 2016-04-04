package com.IOTest;
import java.io.*;

public class IOTestFileOutput{

	public static void main(String[] args){
		
		File fl1 = new File("d:\\Test\\IOTest\\testDir\\tmp992.txt");
		File fl3 = new File("d:\\Test\\IOTest\\testDir\\DVD.rmvb");
		IOTestFileOutput.createFile(fl1);
		//FileOutputStream 不需要保证文件存在就可以直接创建和写入,但是需要创建目录!!!!
		
		//File fl2 = new File("d:\\Test\\IOTest\\DVD.rmvb");		
		File fl2 = new File("d:\\Test\\IOTest\\tmp999.txt");
		FileInputStream fi = null;
		FileOutputStream fo = null;
		byte[] bytes = new byte[1024];
		int n = 0;
		String s = "Hello World!";
		
		try {
			fo = new FileOutputStream(fl1);
			fo.write(s.getBytes()); //向流中写入byte数组
			//当fo写入流被关闭,再次向同一文件write()时则会覆盖原文件的内容!!!
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			try {
				fo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			fi = new FileInputStream(fl2);
			fo = new FileOutputStream(fl3);
			while( (n = fi.read(bytes)) != -1){	
				//System.out.println("n =" + n);
				fo.write(bytes,0,n);
				bytes = new byte[1024];//切记在此位置重置一遍数组,否则数组将存在没有被完全覆盖的垃圾数据
				//如何进行修改式写入?
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			try{
				System.out.println("Close FileStream!");
				fi.close();
				fo.close();
			} catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public static void createFile(File fl){
		
		if(!fl.exists()){//如果文件不存在,则创建文件
			File fPath = fl.getParentFile();
			if(!fPath.isDirectory()){//如果文件目录不存在创建文件目录
				fPath.mkdirs();
			}
			try {
				fl.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
