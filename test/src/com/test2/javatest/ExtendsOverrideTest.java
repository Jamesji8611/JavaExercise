package com.test2.javatest;

public class ExtendsOverrideTest {	
	public static void main(String[] args){
		Son b = new Son();
		b.getA();
		b.getSuperA();
	}
}
class Father{
	public int a = 5;
}
class Son extends Father{
	public int a = 9;
	public void getA(){
		System.out.println("a=" + a);
		System.out.println("a=" + this.a);
	}
	public void getSuperA(){
		System.out.println("Super.a=" + super.a);
	}
}
