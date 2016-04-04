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
		System.out.println("父类中的Static方法！");
	}
	public static String extend1(){
		//System.out.println("父类中的Static方法！extend1()");
		return "父类中的Static方法！extend1()";
	}
	public ExtendT(){
		
	}
}
class ExtendSon extends ExtendT{
	int age;
	String name;
	String city;
	public ExtendSon(){
		System.out.println(super.extend1()); //调用父类中的方法
		age = super.Age;	//调用父类中的变量
		//name = super.Name; //private 属性值子类也不能使用
		city = super.City;	//protected 属性值子类可以使用
		System.out.println("age ="+this.age+" city="+this.city);
	};
}