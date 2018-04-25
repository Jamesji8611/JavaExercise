package com.myjavacode.io;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOTest {

	private static String path="D:\\MyJavacode\\IOFile\\";
	private static String floder = null;

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		floder = sdf.format(new Date());
		//System.out.println( path + floder );
		
		IOTest t = new IOTest();
		//path = ".\\";
		//�˴������·��Ϊ����ڹ��̵ĸ�Ŀ¼����.\\���ڵ�ǰĿ¼�£�������JavaCode����Ŀ¼��(workspace\JavaCode\) 
		try {
			t.createFile(path+floder+"\\","IOFile.project");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public File createFile(String path, String filename) throws IOException {
		
		File file = new File(path+filename);
		File filepath = new File(path);
		if(file.exists()) {
			System.out.println("File exist");
		}else {
			System.out.println("File not exist...");
			if(!filepath.isDirectory()){
				filepath.mkdirs();
			}
			file.createNewFile();
			System.out.println("File path has been created, getAbsolutePath: "+ file.getAbsolutePath());
			System.out.println("File path has been created, getPath: "+ file.getPath());
			System.out.println("File path has been created, getAbsoluteFile: "+ file.getAbsoluteFile());
		}
		
		return file;
	}
}


