package com.StaticTest;

public class StaticT {
	public static void main(String[] args){
		System.out.println("静态变量使用类调用："+StaticTest.getCountry());  //静态变量和静态方法不需要new对象和实例化即可被调用
			//静态变量和方法在进程启动时即分配内存，不论是否new对象，空间始终存在。
		StaticTest.PrintF1();
		StaticTest s1 = new StaticTest("s1",1,"CN");
		s1.PrintF();	//输出结果：Name=s1 Age=1 Country=CN
		StaticTest s2 = new StaticTest("s2",2,"USA");//对象s2的实例化改变了s1.Country 的值
		s1.PrintF();	//输出结果：Name=s1 Age=1 Country=USA
		s2.PrintF();	//输出结果：Name=s2 Age=2 Country=USA
		
		s1.setCountry("England");//同时改变了s1和s2的Country的值
		s1.PrintF();	//输出结果：Name=s1 Age=1 Country=England
		s2.PrintF();	//输出结果：Name=s2 Age=2 Country=England
	}
}
class StaticTest{
	private String Name;
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

	public static String getCountry() {
		return Country;
	}

	public static void setCountry(String country) {
		Country = country;
	}

	private int Age;
	private static String Country="CN0"; //静态变量
	
	public StaticTest(String Name,int Age,String Country){
		this.Name = Name;
		this.Age = Age;
		this.Country = Country;
	}
	
	public void PrintF(){
		System.out.println("Name="+this.Name+" Age="+this.Age+" Country="+Country);
	}
	public static void PrintF1(){
		System.out.println("静态方法在进程启动时即分配空间，无论是否new对象 static Country="+Country);
	}
}