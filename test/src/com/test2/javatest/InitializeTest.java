package com.test2.javatest;

public class InitializeTest {
	public static void main(String[] args){
		Leaf a = new Leaf();
		Leaf b = new Leaf();
		a.printF();
		b.printF();
		Test t = new Test();
		System.out.println(t.t);
	}
}

class Root{
	
	public int root = 9;
	public static int staticRoot = 10;
	//System.out.println("类中的执行语句只能在方法中或初始化块中执行");
	
	static{ //静态初始化
		staticRoot = 101;
		System.out.println("Root 的静态初始化" + " staticRoot=" + staticRoot);
	}
	{//普通初始化块
		root = 99;
		staticRoot = 1010;
		System.out.println("Root 的普通初始化" + "root=" + root + " staticRoot=" + staticRoot);
	}
	
	public Root(){
		System.out.println("Root 的无参构造方法" + " root=" + root + " staticRoot" + staticRoot);
	}//静态方法和静态初始化块中不能调用非静态成员，非静态方法和非静态初始化块中可以调用静态成员和非静态成员
	public void printF(){
		System.out.println("root=" + root + " staticRoot=" + staticRoot);
	}
	
}
class Mid extends Root{
	static{
		System.out.println("Mid 的静态初始化块");
	}
	{
		System.out.println("Mid 的普通初始化块");
	}
	public Mid(){
		System.out.println("Mid 的无参数构造方法");
	}
	public Mid(String a){
		this();
		System.out.println("Mid 的有参数构造方法 " + a + " root=" + root + " staticRoot=" + staticRoot);
	}
}
class Leaf extends Mid{
	static{
		System.out.println("Leaf 的静态初始化块");
	}
	{
		System.out.println("Leaf 的非静态初始化块");
	}
	public Leaf(){
		super("Hello Initialize");
		System.out.println("Leaf 的无参数构造方法");
	}
}
class Test{
	static{
		t =99;
	}
	static int t = 9;
}