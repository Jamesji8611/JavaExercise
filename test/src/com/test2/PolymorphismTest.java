package com.test2;

public class PolymorphismTest {
	public static void main(String[] args){
		Father F = new Father(); //��������������ʵ��
		Son S = new Son(); //��������������ʵ��
		Father Fs = new Son(); //��������������ʵ�֣����ڶ�̬
		
		//Father�������
		System.out.println("Father.A = " + F.A + " Father.B = " + F.B);
		F.polumorphismMethod();
		F.fatherMethod();
		
		//Son�������
		System.out.println("Son.A = " + S.A + " Son.B = " + S.B);
		S.polumorphismMethod();
		S.sonMethod();
		
		//polymorphism ��̬������
		System.out.println("Fs.A = " + Fs.A); //��Ա����������Override�Ͷ�̬
		Fs.polumorphismMethod(); //�����з�������ʱ�������з���Override
		Fs.fatherMethod(); //�����еķ���û����������ʵ�֣��ʱ���ԭ���෽������
		//Fs.sonMethod(); //�������޴˷�������˱���ʱ�ͻᱨ����
	}

}
class Father{
	public String A = "�����е�һ������A";
	public String B = "�����е�һ������B";
	
	public void polumorphismMethod(){
		System.out.println("�����Override����polumorphismMethod");
	}
	public void fatherMethod(){
		System.out.println("���෽��fatherMethod");
	}
	
}
class Son extends Father{
	public int A = 99;
	
	public void polumorphismMethod(){
		System.out.println("�����з���polumorphismMethod");
	}
	public void sonMethod(){
		System.out.println("���෽��sonMethod");
	}
}