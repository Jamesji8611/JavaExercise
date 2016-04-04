package com.StaticTest;

public class StaticTest2 {
	static int i = 1;
	static{
		System.out.println("静态区域块在程序运行起始就被执行");
		System.out.println("起始的i = " + StaticTest2.i);
		i++;
		System.out.println("静态化块中i = " + StaticTest2.i);
	}
	public StaticTest2(){
		i++;
	}
	
	public static void main(String[] args){
		System.out.println("main函数中无实例化");
	}
	
}
