package com.test2;

import java.math.BigDecimal;

public class TestChar {
	public static void main(String[] args){
		char char1 = 'a';
		char char2 = '\t';
		String char3 = "\\r";
		char char4 = '中';
		char char5 = '\u9999';
		
		int int1 = char1;
		int int2 = char1 + char2;
		
		System.out.println(char1 + "	" + char2 + "	" + char3 + "	" + char4 +"	" + char5);
		System.out.println(int1 + "	" + int2);
		
		//int int3 = 99L; //错误，不能进行如此的强制类型转换
		//long int4 = 999999999999999999;	//错误，数位后不加L 系统默认此数为int形
		long int5 = 999999999999999999L; //正确！
		long int6 = 99L; //正确，为long形
		long int7 = 99; //正确，为int形
		
		//System.out.println(int3 + "	" + int4 + "	" + int5);
		
		//BigDecimal a = 9.99987654998;
		
	}
}
