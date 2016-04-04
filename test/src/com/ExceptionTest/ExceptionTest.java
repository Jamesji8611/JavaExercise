package com.ExceptionTest;

public class ExceptionTest {
	public static void main(String[] args){
		try {
			ExceptionT1 t1 = new ExceptionT1(5,0);
		} catch (ExceptionT e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			ExceptionT2 t2 = new ExceptionT2(5,2);
		}catch(ExceptionT e){
			e.printStackTrace();
		}
		
	}
}

class ExceptionT extends Exception{
	public ExceptionT(String Msg){
		super(Msg);
	}
}
class ExceptionT1{
	public ExceptionT1(int a,int b) throws ExceptionT{
		double c;
		c = a/b;
		System.out.println(a+"/"+b+" = "+c);
	}
}
class ExceptionT2{
	public ExceptionT2(int a,int b) throws ExceptionT{
		double c;
		c = (double)a/b;
		System.out.println(a+"/"+b+" = "+c);
	}
}