package com.extendTest;

public class AbstractTest {
	public static void main(String[] args){
		//AbstractT F = new AbstractT();  �����಻�ܱ�ʵ������
		AbstratctT1 Z = new AbstratctT1();
		Z.AbstratctT12();
		Z.printF(); //��������д�ĳ��󷽷�
		Z.printF1();//�����༯�ɵĸ�����ͨ����
	}
}
abstract class AbstractT{
	String Name;	//abstact�ؼ���ֻ��������ͷ�������ͨ���Բ��ܱ�����
	String City = "����";
	int Age= 15;
	public abstract String printF();	//���󷽷�������ʵ�ֹ���
	public void printF1(){	//��������Ҳ���д�����ͨ�ķ����͹��췽��
		System.out.println("����������ͨ���� this.Name="+this.Name+" this.City="+this.City+" this.Age="+this.Age);
	}
}

class AbstratctT1 extends AbstractT{
	public void AbstratctT12(){
		this.Name = "AbstractT";
		this.City = "����";
		this.Age = 20;
		System.out.print("�̳��е��ø���ķ��� ");
		super.printF1();
	}
	
	public String printF(){
		 System.out.println("�����и�д���󷽷� this.Name="+this.Name+" this.City="+this.City+" this.Age="+this.Age);
		 return "0";
	}
}
