package com.test2;
import java.lang.Math;
/**
 * 
 * @author Administrator
 * @return 返回一个六位的随机字符串
 *
 */

public class Test_RandomStr {
	public static void main(String[] args){
		String str1 = "";
		
		for(int i =0; i < 6; i++){
			double j = Math.random(); //生成一个0~1之间的随机数
			System.out.println("Random["+i+"]="+j);
			
			str1 += (char)((int)(j*26)+97); //生成一个97~122之间的char型数
		}
		
		System.out.println(str1);
		float a = 5.6F;	//5.6编译器默认为double型，需要后加F表示浮点，或做强制类型转换(Float)
		double b = 5.7;
		float c = a;
		float d = (float)b;	//b为double型，赋给float型会损失精度编译器报错。需要强制类型转换(Float)
		double e = a;	//a为float型，赋给double型不会损失精度
		
		System.out.println("Hello!" + 'a' + 10); //输出结果：Hello!a10
		System.out.println('a' + 10 + "Hello!"); //输出结果：107Hello！
		
		System.out.println("正无穷大："+ 10/0.0);
		System.out.println("负无穷大："+ 10/-0.0);
		
	}
}
