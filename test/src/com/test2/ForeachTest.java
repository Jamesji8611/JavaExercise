/**
 * @author James
 * @date	22/January/2016
 * @function foreach �� forloop ֮��ıȽ�
 * @foreach�﷨ for(�������� ���� �� ����򼯺�)
 * @���ۣ�foreach һ��ֻ������ͼ��ϵı��������޷��ı�����ͼ����е�Ԫ�أ���
 */
package com.test2;

import java.util.Arrays;

public class ForeachTest {
	public static void main(String[] args){
		int[] s1 = new int[3];
		Arrays.fill(s1, 1); //Arrays�෽������
		System.out.println("-----------����δ��ʼ��������-----------");
		for(int x : s1){
			System.out.print(x);
		}
		System.out.println("\n-----------��ͼ�����鸳ֵ-----------");
		for(int y : s1){
			y = 5;
			System.out.print(y);
		}//����foreach ��ʽ���޷��ı������е�Ԫ�أ�y������ֻ�Ǹ���ʱ��ӳ�䣬�޷����õ������ϣ�����
		System.out.println("\n-----------������ͼ�ı������-----------");
		for(int z : s1){
			System.out.print(z);
		}
		System.out.println("\n-----------ʹ��forѭ���ı�����ĳ�ֵ-----------");
		for(int i = 0; i < s1.length; i++){
			s1[i] = i;
		}
		System.out.println("\n-----------����forloop�ı�������-----------");
		for(int z : s1){
			System.out.print(z);
		}
	}
}
