package com.StaticTest;

public class StaticTest2 {
	static int i = 1;
	static{
		System.out.println("��̬������ڳ���������ʼ�ͱ�ִ��");
		System.out.println("��ʼ��i = " + StaticTest2.i);
		i++;
		System.out.println("��̬������i = " + StaticTest2.i);
	}
	public StaticTest2(){
		i++;
	}
	
	public static void main(String[] args){
		System.out.println("main��������ʵ����");
	}
	
}
