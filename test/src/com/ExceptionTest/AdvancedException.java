package com.ExceptionTest;

import java.io.*;

public class AdvancedException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Use try/catch methods to catch exceptions");
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		try{
			f = new File("D:/test/No1.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			System.out.println("Test");
		}catch( Exception e){
			System.out.println("Edit a no exist File :" + e.getMessage());
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Can't close the fileBuffered: " + e.getMessage());
				
			}
		}
		
		System.out.println("********************************************************************");
		System.out.println("Use throws methods to catch exception");
		try{
			ThrowsException();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("********************************************************************");
		System.out.println("Use throwException methods to catch exception");
		try{
			ThrowException();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println("********************************************************************");
		System.out.println("Defined an Exception for catching exception");
		try{
			throw new DefinedException();
		}catch(DefinedException d){
			System.out.println(d.getMessage());
			d.printStackTrace();
		}
	}
	
	public static void ThrowsException() throws Exception{//将异常抛出给调用者
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		f = new File("D:/test/No2.txt");
		fr = new FileReader(f);
		br = new BufferedReader(fr);
		System.out.println("Test");
	}
	
	public static void ThrowException() throws RuntimeException{//类似于自定义了一个异常,并将异常抛出给调用者
		
		File f = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			f = new File("D:/test/No3.txt");
			fr = new FileReader(f);
			br = new BufferedReader(fr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Not found the File: " + f.getAbsolutePath() );
		}
		
		System.out.println("Test");
	}
	
}

class DefinedException extends Exception{
	
	public DefinedException(){
		super("Defined an exception");
	}
}