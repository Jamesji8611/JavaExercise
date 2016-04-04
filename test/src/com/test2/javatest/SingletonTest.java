package com.test2.javatest;
/**
 * 
 * @author James
 * @funciton ������ Singleton
 *
 */
public class SingletonTest {
	public static void main(String[] args){
		
		Singleton T1 = Singleton.Create();
		Singleton T2 = Singleton.Create();
		System.out.println("������T1��T2�Ƿ�ָ��ͬһ��ʵ���� " + (T1 == T2 ?true:false));
		System.out.println("*********************************************");
		Singleton.Drop();
		System.out.println("T1 = " + T1 + " T2 = " + T2);
		System.out.println("*********************************************");
		T1 = Singleton.Create();
		System.out.println("���´�����T1:");
		Singleton T3 = Singleton.Create();
		System.out.println("���´�����T1��T2�Ƿ�ָ��ͬһ��ʵ���� " + (T1 == T2 ?true:false));
		System.out.println("���´�����T1���´���T3�Ƿ�ָ��ͬһ��ʵ���� " + (T1 == T3 ?true:false));
	}
}
class Singleton{
	private static Singleton SingleT; //����һ����̬�Ļ������Ա����Դ�����ʵ��
	private Singleton(){
		System.out.println("����һ��private��Constructor���Ա�֤������ͷ����޷�����ʵ��");
	}
	public static Singleton Create(){
		if(SingleT == null){
			SingleT = new Singleton();
			System.out.println("�������û�д�����ʵ������Singleton is null���򴴽�һ��ʵ��");
		}else{//����Ѿ�������ʵ������Singleton is not null,ֱ�ӷ���SingleT ���Ѿ���������ʵ��
			System.out.println("�����Ѿ�������ʵ�������ش�������ʵ��SingleT");
		}
		return SingleT;
	}
	public static void Drop(){
		System.out.println("�ͷŵ���������ʵ����");
		SingleT = null;
	}
}
