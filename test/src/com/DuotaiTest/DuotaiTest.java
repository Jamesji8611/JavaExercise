package com.DuotaiTest;

public class DuotaiTest {
	public static void main(String args[]){
		System.out.println("������������ʵ������");
		DuotaiT1 T1= new DuotaiT1();
		T1.T();
		T1.T1();
		DuotaiT2 T2 = new DuotaiT2();
		T2.T();
		T2.T2();
		System.out.println("*********************");
		/***********************/
		System.out.println("DuotaiT1 T3= new DuotaiT2(); ��������������ʵ����");
		DuotaiT1 T3= new DuotaiT2();
		System.out.println("���в�����"+T3.T1+" T="+T3.T);	//���ء���д�Ͷ�̬�ĸ���ֻ����Է�������Ա������ֵ����ı�
		T3.T();//���ʱ���Ѿ��Ǳ����ิд����T()���� �������������з���T
		T3.T1();//����ֻ��ʹ�ø���ķ���
		System.out.println("*********************");
		System.out.println("DuotaiT2 T4= new DuotaiT2(); ��������������ʵ����");
		DuotaiT2 T4= new DuotaiT2(); //��������������������ʵ�������������ɼ���ʵ�������������
		System.out.println("���в�����"+T4.T2+" T="+T4.T);
		T4.T();
		T4.T1();//����ֻ��ʹ�ø���ķ���
		T4.T2();
		/*************************/
	}
}
class DuotaiT1{
	String T1 ="����";
	String T ="�����еı���T";
	public void T(){
		System.out.println("�����еķ���T");
	}
	public void T1(){
		System.out.println("�����еķ���T1");
	}
}
class DuotaiT2 extends DuotaiT1{
	String T2 ="����";
	String T ="�����еı���T";
	public void T(){
		System.out.println("�����з���T");
	}
	public void T2(){
		System.out.println("�����з���T2");
	}
}