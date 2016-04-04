package com.DuotaiTest;

public class DuotaiTest {
	public static void main(String args[]){
		System.out.println("正常的声明及实例化：");
		DuotaiT1 T1= new DuotaiT1();
		T1.T();
		T1.T1();
		DuotaiT2 T2 = new DuotaiT2();
		T2.T();
		T2.T2();
		System.out.println("*********************");
		/***********************/
		System.out.println("DuotaiT1 T3= new DuotaiT2(); 父类声明，子类实例化");
		DuotaiT1 T3= new DuotaiT2();
		System.out.println("类中操作："+T3.T1+" T="+T3.T);	//重载、复写和多态的概念只是针对方法，成员变量的值不会改变
		T3.T();//这个时候已经是被子类复写过的T()方法 输出结果：子类中方法T
		T3.T1();//还是只能使用父类的方法
		System.out.println("*********************");
		System.out.println("DuotaiT2 T4= new DuotaiT2(); 子类声明，父类实例化");
		DuotaiT2 T4= new DuotaiT2(); //不允许子类声明，父类实例化，不允许由简单项实例化复杂项！！！
		System.out.println("类中操作："+T4.T2+" T="+T4.T);
		T4.T();
		T4.T1();//还是只能使用父类的方法
		T4.T2();
		/*************************/
	}
}
class DuotaiT1{
	String T1 ="父类";
	String T ="父类中的变量T";
	public void T(){
		System.out.println("父类中的方法T");
	}
	public void T1(){
		System.out.println("父类中的方法T1");
	}
}
class DuotaiT2 extends DuotaiT1{
	String T2 ="子类";
	String T ="子类中的变量T";
	public void T(){
		System.out.println("子类中方法T");
	}
	public void T2(){
		System.out.println("子类中方法T2");
	}
}