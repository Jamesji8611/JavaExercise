/**
 * File �Ļ����÷�
 */
package com.IOTest;
import java.io.*;

public class IOTestFileInput {
	
	public static void main(String[] args){
		//Create a File
		File f = new File("C:\\Users\\Administrator\\Desktop\\tmp2.txt");
		
		//��ȡ�ļ�����
		System.out.println("FileName: " + f.getName() + " FilePath:" + f.getPath() + " FileSize: " + f.length());
		System.out.println("FilePath = " + f.getParentFile());//��ȡ�ļ�Ŀ¼
		File f1 = new File("d:\\Test\\IOTest");
		File f2 = new File("d:\\Test\\IOTest\\tmp999.txt");
		System.out.println((f1 == null)?"Null":f.getName());//�˴��ļ�������,����f�������ͱ����Ǵ��ڵ�
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
		
		//��ȡ�ļ������ļ�:
		if(f1.isDirectory()){
			File[] fd = f1.listFiles();
			System.out.println(f1.getName() + "�ļ������ļ�:");
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
				//read(byte) ���������н���� byte.length ���ֽڵ����ݶ���һ�� byte ������,���byte��������򷽷�����,�ڷ���һ��int�����,
				//����ֵΪ��ȡ���ֽ���,�����ȡ���ļ�ĩβ�򷵻�-1
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
