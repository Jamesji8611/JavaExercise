package com.PrivateTest;

public class PrivateTest {
	public void mian(String[] args){
		
	}
}

class PrivateT{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int	age;
	private void talk(){
		System.out.println("My name is "+name+",I'm "+age);
	}
	
	
}