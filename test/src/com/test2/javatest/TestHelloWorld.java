package com.test2.javatest;

import com.test2.Test_RandomStr;	//不同包中的类需要使用import引入！！

public class TestHelloWorld {
	public static void mian(String[] args){
		HelloWorld h = new HelloWorld(); //同一包中的类可以直接调用而不需要import
		
		Test_RandomStr t = new Test_RandomStr(); //不同包中的类需要使用import引入！！
		com.test2.Test_RandomStr t1 = new com.test2.Test_RandomStr(); //或者直接使用包名引入！！！
		
	}
}
