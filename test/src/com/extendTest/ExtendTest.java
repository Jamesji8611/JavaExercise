package com.extendTest;

public class ExtendTest {
	public static void main(String[] args){
		ExtendSon T1 = new ExtendSon();
	}
}

class ExtendT{
	private String Name;
	int Age;
	protected String City;
	static{
		System.out.println("�����е�Static������");
	}
	public static String extend1(){
		//System.out.println("�����е�Static������extend1()");
		return "�����е�Static������extend1()";
	}
	public ExtendT(){
		
	}
}
class ExtendSon extends ExtendT{
	int age;
	String name;
	String city;
	public ExtendSon(){
		System.out.println(super.extend1()); //���ø����еķ���
		age = super.Age;	//���ø����еı���
		//name = super.Name; //private ����ֵ����Ҳ����ʹ��
		city = super.City;	//protected ����ֵ�������ʹ��
		System.out.println("age ="+this.age+" city="+this.city);
	};
}