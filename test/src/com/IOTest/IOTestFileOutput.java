package com.IOTest;
import java.io.*;

public class IOTestFileOutput{

	public static void main(String[] args){
		
		File fl1 = new File("d:\\Test\\IOTest\\testDir\\tmp992.txt");
		File fl3 = new File("d:\\Test\\IOTest\\testDir\\DVD.rmvb");
		IOTestFileOutput.createFile(fl1);
		//FileOutputStream ����Ҫ��֤�ļ����ھͿ���ֱ�Ӵ�����д��,������Ҫ����Ŀ¼!!!!
		
		//File fl2 = new File("d:\\Test\\IOTest\\DVD.rmvb");		
		File fl2 = new File("d:\\Test\\IOTest\\tmp999.txt");
		FileInputStream fi = null;
		FileOutputStream fo = null;
		byte[] bytes = new byte[1024];
		int n = 0;
		String s = "Hello World!";
		
		try {
			fo = new FileOutputStream(fl1);
			fo.write(s.getBytes()); //������д��byte����
			//��foд�������ر�,�ٴ���ͬһ�ļ�write()ʱ��Ḳ��ԭ�ļ�������!!!
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
				bytes = new byte[1024];//�м��ڴ�λ������һ������,�������齫����û�б���ȫ���ǵ���������
				//��ν����޸�ʽд��?
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
		
		if(!fl.exists()){//����ļ�������,�򴴽��ļ�
			File fPath = fl.getParentFile();
			if(!fPath.isDirectory()){//����ļ�Ŀ¼�����ڴ����ļ�Ŀ¼
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
