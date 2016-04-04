package com.ChongzaiT;

public class ChongzaiTest {
	public static void main(String[] args){
		ChongzaiT T1 = new ChongzaiT();			//调用无参的构造函数
		ChongzaiT T2 = new ChongzaiT("有参",1);	//调用有参的构造函数
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
		this.Name = "无参";
		this.age = 0;
		System.out.println("无参构造方法：Name="+this.Name+" age="+this.age);
	}
	ChongzaiT(String Name,int age){ //方法的重载  又是一个构造方法重载的例子。
		this.Name = Name;
		this.age = age;
		System.out.println("有参构造方法：Name="+this.Name+" age="+this.age);		
	}
}