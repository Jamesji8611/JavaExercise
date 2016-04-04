package com.test2;

public class ConstructorOverload {
	public static void main(String[] args){
		Constructor C1 = new Constructor("James", 28);
		C1.getField();
		C1 = new Constructor("Lynn", 27, "New Zealand");
		C1.getField();
	}

}

class Constructor{
	private String name; //��׼��װ standard encapsulation
	private int age;
	private String liveAddress;
	
	public Constructor(String name, int age){ //���췽�� constructor ʹ��public����
		this.name = name;
		this.age = age;
	}
	
	public Constructor(String name, int age, String liveAddress){ //���췽�������� Constructor overLoad
		//System.out.println("ʹ��this��ʵ�ֵ��ã�ֻ�������ع������ĵ�һ�У���ֻ���ڹ�������ʹ�ã�������");
		this(name, age); //���췽�����أ���Ҫ������һ�����췽��ʱ����ֱ���������������ã�ֻ��ʹ��this���棡��
		this.liveAddress = liveAddress;
	}
	
	public String getName(){
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	public String getLiveAddress(){
		return this.liveAddress;
	}
	public void getField(){ //��ͨ���� method ������������
		System.out.println("Name: " + this.getName() + " Age: " + this.getAge() + " LiveAddress: " + this.liveAddress);		
	}
}