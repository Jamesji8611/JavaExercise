package com.ChongzaiT;

public class ChongzaiTest {
	public static void main(String[] args){
		ChongzaiT T1 = new ChongzaiT();			//�����޲εĹ��캯��
		ChongzaiT T2 = new ChongzaiT("�в�",1);	//�����вεĹ��캯��
	}
}

class ChongzaiT{
	private String Name;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int	age;
	
	ChongzaiT(){
		this.Name = "�޲�";
		this.age = 0;
		System.out.println("�޲ι��췽����Name="+this.Name+" age="+this.age);
	}
	ChongzaiT(String Name,int age){ //����������  ����һ�����췽�����ص����ӡ�
		this.Name = Name;
		this.age = age;
		System.out.println("�вι��췽����Name="+this.Name+" age="+this.age);		
	}
}