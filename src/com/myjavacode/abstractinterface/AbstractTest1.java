package com.myjavacode.abstractinterface;

public class AbstractTest1 extends AbstractTest{

	public AbstractTest1(int id, int age, String name, String food) { //构造方法
		super(id, age, name, food);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String eat() {  //重写抽象方法
		// TODO Auto-generated method stub
		return this.getFood();
	}
	
	public static void main(String[] args) {
		AbstractTest1 a = new AbstractTest1(1,10,"WangWang","Bone");
		AbstractTest b = new AbstractTest1(2,15,"MiaoMiao","Meat");
		
		System.out.println(a.getName() + " eat "+ a.eat());
		System.out.println(b.getName() + " eat "+ b.eat());
		
	}

}
