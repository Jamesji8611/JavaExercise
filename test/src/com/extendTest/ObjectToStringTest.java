package com.extendTest;

public class ObjectToStringTest {
	public static void main(String[] args){
		ObjectToStringT t = new ObjectToStringT("t",0);
		ObjectToStringT1 t1 = new ObjectToStringT1("t1",1);
		
		System.out.print(t+"   ");
		System.out.println(t.toString());
		System.out.print(t1+"   ");
		System.out.println(t1.toString());
		
	}
}
class ObjectToStringT extends Object{ //�ȼ���class ObjectToStringT
	private String Name;
	private int Age;
	public ObjectToStringT(String Name,int Age){
		this.Age = Age;
		this.Name =Name;
	}
}
class ObjectToStringT1{ //�ȼ���class ObjectToStringT1 extends Object//��дtoString()����
	private String Name;
	private int Age;
	public ObjectToStringT1(String Name,int Age){
		this.Age = Age;
		this.Name =Name;
	}
	public String toString(){ //��д��Object�е�toString()����
		return "ObjectToStringT1: Age="+this.Age+" Name="+this.Name;
	}
}
