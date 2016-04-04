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
	private String name; //标准封装 standard encapsulation
	private int age;
	private String liveAddress;
	
	public Constructor(String name, int age){ //构造方法 constructor 使用public修饰
		this.name = name;
		this.age = age;
	}
	
	public Constructor(String name, int age, String liveAddress){ //构造方法的重载 Constructor overLoad
		//System.out.println("使用this来实现调用，只能在重载构造器的第一行，且只能在构造器中使用！！！！");
		this(name, age); //构造方法重载，需要复用另一个构造方法时不能直接像其他方法调用，只能使用this代替！！
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
	public void getField(){ //普通方法 method 调用其他方法
		System.out.println("Name: " + this.getName() + " Age: " + this.getAge() + " LiveAddress: " + this.liveAddress);		
	}
}