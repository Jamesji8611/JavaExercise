package com.myjavacode.jdbc;

import java.sql.Date;

public class BeanCustomers {
	
	private int ID;
	private String Name;
	private int Age;
	private Date DOB;
	private String Sex;
	
	
	public BeanCustomers(int ID, String Name, int Age, Date DOB, String Sex) {
		
		this.ID = ID;
		this.Name = Name;
		this.Age = Age;
		this.DOB = DOB;
		this.Sex = Sex;
	}
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	
	public void printData() {
		System.out.println("ID:" +this.ID +" Name:" +this.Name +" Age:" +this.Age +" DOB:" + this.DOB + " Sex:" + this.Sex);
	}

}
