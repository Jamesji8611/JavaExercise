package com.extendTest;

public class ExtendTest1 {
	public static void main(String[] args){
		Person p = new Person("Person","Beijing",10);
		p.printF();
		Student s = new Student("Student","Beijing",15,1);
		s.printF();//子类复写了父类的方法
	}
}
class Person{
	String Name;
	String City;
	int Age;
	int others = 9;
	
	public Person(String Name,String City,int Age){
		this.Name = Name;
		this.Age = Age;
		this.City = City;
	}
	public Person(){
		 
	}
	public void printF(){
		System.out.println("Person: Name="+this.Name+" City="+this.City+" Age="+this.Age + " this.others=" + this.others);
	}
}
class Student extends Person{
	int ID;
	int others = 5; //重写属性
	
	public Student(String Name,String City,int Age,int ID){
		//this.City = "Guangzhou";//super()父类的构造函数必须在子类赋值前！！
		//super();
		super(Name,City,Age); //super()父类的构造函数必须在子类赋值前！！
		//子类实例化时其实同时实例化了一个父类！！！！
		//如无super(Name,City,Age);语句实例化父类，只是实例化了子类，依然可以通过super.Name等获取与子类相同的值
		//相当于先开辟了一个父类的对象内存，再对此对象进行内存改造？
		System.out.println("子类构造函数中super父类：super.Name="+super.Name+" super.Age="+super.Age+" super.City="+super.City + " super.others=" + super.others);
		this.Age = 150;
		System.out.println("子类构造函数中修改部分值：this.Name="+this.Name+" this.Age="+this.Age+" this.City="+this.City+" this.ID="+this.ID + " this.others=" + this.others);
		System.out.println("子类构造函数中修改部分值后的super父类：super.Name="+super.Name+" super.Age="+super.Age+" super.City="+super.City + " super.others=" + super.others );
		this.ID = ID;
		
	}
	public void printF(){
		System.out.println("Person: Name="+super.Name+" City="+super.City+" Age="+super.Age + " super.others=" + super.others );
		System.out.println("Student: Name="+this.Name+" City="+this.City+" Age="+this.Age+" ID="+this.ID + " others=" + this.others);
	}
}