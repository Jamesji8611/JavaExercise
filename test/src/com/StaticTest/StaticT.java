package com.StaticTest;

public class StaticT {
	public static void main(String[] args){
		System.out.println("��̬����ʹ������ã�"+StaticTest.getCountry());  //��̬�����;�̬��������Ҫnew�����ʵ�������ɱ�����
			//��̬�����ͷ����ڽ�������ʱ�������ڴ棬�����Ƿ�new���󣬿ռ�ʼ�մ��ڡ�
		StaticTest.PrintF1();
		StaticTest s1 = new StaticTest("s1",1,"CN");
		s1.PrintF();	//��������Name=s1 Age=1 Country=CN
		StaticTest s2 = new StaticTest("s2",2,"USA");//����s2��ʵ�����ı���s1.Country ��ֵ
		s1.PrintF();	//��������Name=s1 Age=1 Country=USA
		s2.PrintF();	//��������Name=s2 Age=2 Country=USA
		
		s1.setCountry("England");//ͬʱ�ı���s1��s2��Country��ֵ
		s1.PrintF();	//��������Name=s1 Age=1 Country=England
		s2.PrintF();	//��������Name=s2 Age=2 Country=England
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
	private static String Country="CN0"; //��̬����
	
	public StaticTest(String Name,int Age,String Country){
		this.Name = Name;
		this.Age = Age;
		this.Country = Country;
	}
	
	public void PrintF(){
		System.out.println("Name="+this.Name+" Age="+this.Age+" Country="+Country);
	}
	public static void PrintF1(){
		System.out.println("��̬�����ڽ�������ʱ������ռ䣬�����Ƿ�new���� static Country="+Country);
	}
}