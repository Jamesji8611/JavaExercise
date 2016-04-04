package com.extendTest;

public class AbstractTest {
	public static void main(String[] args){
		//AbstractT F = new AbstractT();  抽象类不能被实例化！
		AbstratctT1 Z = new AbstratctT1();
		Z.AbstratctT12();
		Z.printF(); //被子类重写的抽象方法
		Z.printF1();//被子类集成的父类普通方法
	}
}
abstract class AbstractT{
	String Name;	//abstact关键字只能修饰类和方法，普通属性不能被修饰
	String City = "北京";
	int Age= 15;
	public abstract String printF();	//抽象方法不能有实现过程
	public void printF1(){	//抽象父类中也运行存在普通的方法和构造方法
		System.out.println("抽象父类中普通方法 this.Name="+this.Name+" this.City="+this.City+" this.Age="+this.Age);
	}
}

class AbstratctT1 extends AbstractT{
	public void AbstratctT12(){
		this.Name = "AbstractT";
		this.City = "广州";
		this.Age = 20;
		System.out.print("继承中调用父类的方法 ");
		super.printF1();
	}
	
	public String printF(){
		 System.out.println("子类中复写抽象方法 this.Name="+this.Name+" this.City="+this.City+" this.Age="+this.Age);
		 return "0";
	}
}
