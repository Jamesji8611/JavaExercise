	/**
	 * @author	James
	 * @date	22/January/2016
	 * @function	生成一个随机的int型数组，并对数组做校验和输出
	 */
	package com.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	
	public class ArrayRandom {
		public static void main(String[] args){
			int a = (args.length!=0)?(Integer.valueOf(args[0])):0;	//获取主函数的参数！
			int b = 0;
			if( a == 0){
				System.out.print("请输入需要构建的数组维度：");
				//获取键盘输入！
				while(a <= 0){
					BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
					try {
						a = Integer.parseInt((br.readLine())); //br.readLine() 是真正的从键盘输入的值！
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					b = -1;
					if( a <= 0 && b != 0){
						System.out.print("数组长度必须大于0，请重新输入：");
					}
				}
			}
			RandomG a1 = new RandomG(a);	//构造方法
			a1.RandomP();
		}
	}
	
	class RandomG{
		int[] arr1;	//只是声明了数组，未初始化则系统中无此内存空间，出现空指针！！！
		
		public RandomG(int count){//构造方法
			arr1 = new int[count];  //要记得初始化啊！！！！
			{
				for(int i=0; i<count; i++){
					arr1[i] = (int) (Math.random()*10) ; //Random方法返回一个0~1间的double数！
					//arr1[i] = (int) (Math.random()*26 +97);	//生成一个97~122之间的随机数，即是char型的unicode码！！！
					System.out.println("arr[" + i + "] =" + arr1[i]);
				}
			}while(INZero());
		}
		
		public void RandomP(){//输出数组
			for(int i=0; i<arr1.length; i++){
				System.out.print(arr1[i]);
				//System.out.print((char)arr1[i]);	//将int型转换为强制转换为char型
			}
			System.out.println();
		}
		
		private boolean INZero(){//校验数组不全为0，全为0返回true，否则返回false
			int count =0;
			//System.out.println();
			for(int i = 0; i<arr1.length; i++){
				count += arr1[i];
			}
			return count==0?true:false;
		}
	}