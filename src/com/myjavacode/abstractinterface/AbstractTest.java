package com.myjavacode.abstractinterface;

public abstract class AbstractTest {
	private int id;
	private int age;
	private String name;
	private String food;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	
	public abstract String eat(); //≥ÈœÛ¿‡
	
	public AbstractTest(int id, int age, String name, String food) {
		this.setId(id);
		this.setAge(age);
		this.setName(name);
		this.setFood(food);
	}
	
}
