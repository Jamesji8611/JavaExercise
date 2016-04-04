/**
 * File 的基本用法
 */
package com.IOTest;
import java.io.*;

public class IOTestFileInput {
	
	public static void main(String[] args){
		//Create a File
		File f = new File("C:\\Users\\Administrator\\Desktop\\tmp2.txt");
		
		//获取文件属性
		System.out.println("FileName: " + f.getName() + " FilePath:" + f.getPath() + " FileSize: " + f.length());
		System.out.println("FilePath = " + f.getParentFile());//获取文件目录
		File f1 = new File("d:\\Test\\IOTest");
		File f2 = new File("d:\\Test\\IOTest\\tmp999.txt");
		System.out.println((f1 == null)?"Null":f.getName());//此处文件不存在,但是f引用类型变量是存在的
		if(!f1.isDirectory()){//Create File Directories
			System.out.println("FilePath is not exist");
				f1.mkdirs();
		}
		if(!f2.exists()){//Create File
			try {
				f2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//获取文件夹中文件:
		if(f1.isDirectory()){
			File[] fd = f1.listFiles();
			System.out.println(f1.getName() + "文件夹下文件:");
			for(int i = 0; i < fd.length; i++){
				System.out.print(fd[i].getName() + ", ");
				if(i!=0 && (i+1)%5 == 0){
					System.out.println("");
				}
			}
		}
		
		//InputStream
		FileInputStream ins = null;
		if(f2.exists()){
			try {
				ins = new FileInputStream(f2);
				byte[] bytes = new byte[1024];
				int n = 0;
				while((n = ins.read(bytes)) != -1){
				//read(byte) 从输入流中将最多 byte.length 个字节的数据读入一个 byte 数组中,如果byte数组读满则方法阻塞,在返回一个int后继续,
				//返回值为读取的字节数,如果读取到文件末尾则返回-1
					String s = new String(bytes, 0, n);
					System.out.print(/*"ins.read(bytes)) = " + n + ": " +*/ s);
				}
				System.out.println(n);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					ins.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
