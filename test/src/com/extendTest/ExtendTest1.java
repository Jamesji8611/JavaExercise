package com.extendTest;

public class ExtendTest1 {
	public static void main(String[] args){
		Person p = new Person("Person","Beijing",10);
		p.printF();
		Student s = new Student("Student","Beijing",15,1);
		s.printF();//���ิд�˸���ķ���
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
	int others = 5; //��д����
	
	public Student(String Name,String City,int Age,int ID){
		//this.City = "Guangzhou";//super()����Ĺ��캯�����������ำֵǰ����
		//super();
		super(Name,City,Age); //super()����Ĺ��캯�����������ำֵǰ����
		//����ʵ����ʱ��ʵͬʱʵ������һ�����࣡������
		//����super(Name,City,Age);���ʵ�������ֻ࣬��ʵ���������࣬��Ȼ����ͨ��super.Name�Ȼ�ȡ��������ͬ��ֵ
		//�൱���ȿ�����һ������Ķ����ڴ棬�ٶԴ˶�������ڴ���죿
		System.out.println("���๹�캯����super���ࣺsuper.Name="+super.Name+" super.Age="+super.Age+" super.City="+super.City + " super.others=" + super.others);
		this.Age = 150;
		System.out.println("���๹�캯�����޸Ĳ���ֵ��this.Name="+this.Name+" this.Age="+this.Age+" this.City="+this.City+" this.ID="+this.ID + " this.others=" + this.others);
		System.out.println("���๹�캯�����޸Ĳ���ֵ���super���ࣺsuper.Name="+super.Name+" super.Age="+super.Age+" super.City="+super.City + " super.others=" + super.others );
		this.ID = ID;
		
	}
	public void printF(){
		System.out.println("Person: Name="+super.Name+" City="+super.City+" Age="+super.Age + " super.others=" + super.others );
		System.out.println("Student: Name="+this.Name+" City="+this.City+" Age="+this.Age+" ID="+this.ID + " others=" + this.others);
	}
}