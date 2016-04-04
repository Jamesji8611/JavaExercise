/**
 * @author James
 * @date	22/January/2016
 * @function foreach 和 forloop 之间的比较
 * @foreach语法 for(变量类型 变量 ： 数组或集合)
 * @结论：foreach 一般只做数组和集合的遍历，并无法改变数组和集合中的元素！！
 */
package com.test2;

import java.util.Arrays;

public class ForeachTest {
	public static void main(String[] args){
		int[] s1 = new int[3];
		Arrays.fill(s1, 1); //Arrays类方法！！
		System.out.println("-----------遍历未初始化的数组-----------");
		for(int x : s1){
			System.out.print(x);
		}
		System.out.println("\n-----------试图给数组赋值-----------");
		for(int y : s1){
			y = 5;
			System.out.print(y);
		}//发现foreach 方式并无法改变数组中的元素，y在这里只是个临时的映射，无法作用到数组上！！！
		System.out.println("\n-----------遍历试图改变的数组-----------");
		for(int z : s1){
			System.out.print(z);
		}
		System.out.println("\n-----------使用for循环改变数组的初值-----------");
		for(int i = 0; i < s1.length; i++){
			s1[i] = i;
		}
		System.out.println("\n-----------遍历forloop改变后的数组-----------");
		for(int z : s1){
			System.out.print(z);
		}
	}
}
