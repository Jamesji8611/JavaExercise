package com.YinyongTest;

public class YinyongTest {
	public static void main(String args[]){
		YinyongT a = new YinyongT();  
		YinyongT b = null;			//δʵ����
		
		a.setA1("Aa");
		b = a;						//b����a��ʵ��������b����ָ֤��a��ͬ���ڴ�ռ䣬a��bʹ��ͬһ�ڴ�ռ�������
		System.out.println("a.A1="+a.getA1()+",b.A1="+b.getA1());
		System.out.println("a == b ��"+ (a==b)); //���������ñ���ָ��ͬһʵ��ʱ(��ʹ����ͬ�ڴ�ռ�)�����
		
		b.setA1("Ab");				//b�޸��˹�ͬ�ռ��е�ֵ����ֵͬ��Ӱ��a
		System.out.println("a.A1="+a.getA1()+",b.A1="+b.getA1());
		
		a = new YinyongT();			//a����ʵ����������ԭ�ڴ�ռ䣬��ԭ�ڴ�����b��ָ������bʹ��ԭ�ڴ�ռ���ֵ
		a.setA1("Ac");				//a���¿ռ��е����ݽ��б��������Ӱ��b
		System.out.println("a.A1="+a.getA1()+",b.A1="+b.getA1());
	}
}

class YinyongT{
	private String A1; //��װ��

	public String getA1() {
		return this.A1;
	}

	public void setA1(String a1) {
		this.A1 = a1;
	}
	
}