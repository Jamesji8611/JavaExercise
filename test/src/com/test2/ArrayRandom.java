	/**
	 * @author	James
	 * @date	22/January/2016
	 * @function	����һ�������int�����飬����������У������
	 */
	package com.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
	
	public class ArrayRandom {
		public static void main(String[] args){
			int a = (args.length!=0)?(Integer.valueOf(args[0])):0;	//��ȡ�������Ĳ�����
			int b = 0;
			if( a == 0){
				System.out.print("��������Ҫ����������ά�ȣ�");
				//��ȡ�������룡
				while(a <= 0){
					BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
					try {
						a = Integer.parseInt((br.readLine())); //br.readLine() �������ĴӼ��������ֵ��
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					b = -1;
					if( a <= 0 && b != 0){
						System.out.print("���鳤�ȱ������0�����������룺");
					}
				}
			}
			RandomG a1 = new RandomG(a);	//���췽��
			a1.RandomP();
		}
	}
	
	class RandomG{
		int[] arr1;	//ֻ�����������飬δ��ʼ����ϵͳ���޴��ڴ�ռ䣬���ֿ�ָ�룡����
		
		public RandomG(int count){//���췽��
			arr1 = new int[count];  //Ҫ�ǵó�ʼ������������
			{
				for(int i=0; i<count; i++){
					arr1[i] = (int) (Math.random()*10) ; //Random��������һ��0~1���double����
					//arr1[i] = (int) (Math.random()*26 +97);	//����һ��97~122֮��������������char�͵�unicode�룡����
					System.out.println("arr[" + i + "] =" + arr1[i]);
				}
			}while(INZero());
		}
		
		public void RandomP(){//�������
			for(int i=0; i<arr1.length; i++){
				System.out.print(arr1[i]);
				//System.out.print((char)arr1[i]);	//��int��ת��Ϊǿ��ת��Ϊchar��
			}
			System.out.println();
		}
		
		private boolean INZero(){//У�����鲻ȫΪ0��ȫΪ0����true�����򷵻�false
			int count =0;
			//System.out.println();
			for(int i = 0; i<arr1.length; i++){
				count += arr1[i];
			}
			return count==0?true:false;
		}
	}