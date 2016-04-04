package com.test2;

public class PolymorphismTest {
	public static void main(String[] args){
		Father F = new Father(); //父类声明，父类实现
		Son S = new Son(); //子类声明，子类实现
		Father Fs = new Son(); //父类声明，子类实现，存在多态
		
		//Father类的运行
		System.out.println("Father.A = " + F.A + " Father.B = " + F.B);
		F.polumorphismMethod();
		F.fatherMethod();
		
		//Son类的运行
		System.out.println("Son.A = " + S.A + " Son.B = " + S.B);
		S.polumorphismMethod();
		S.sonMethod();
		
		//polymorphism 多态的运行
		System.out.println("Fs.A = " + Fs.A); //成员变量不存在Override和多态
		Fs.polumorphismMethod(); //父类中方法运行时被子类中方法Override
		Fs.fatherMethod(); //父类中的方法没有在子类中实现，故保留原父类方法运行
		//Fs.sonMethod(); //父类中无此方法，因此编译时就会报错！！
	}

}
class Father{
	public String A = "父类中的一般属性A";
	public String B = "父类中的一般属性B";
	
	public void polumorphismMethod(){
		System.out.println("父类待Override方法polumorphismMethod");
	}
	public void fatherMethod(){
		System.out.println("父类方法fatherMethod");
	}
	
}
class Son extends Father{
	public int A = 99;
	
	public void polumorphismMethod(){
		System.out.println("子类中方法polumorphismMethod");
	}
	public void sonMethod(){
		System.out.println("子类方法sonMethod");
	}
}