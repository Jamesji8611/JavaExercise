package com.YinyongTest;

public class YinyongTest {
	public static void main(String args[]){
		YinyongT a = new YinyongT();  
		YinyongT b = null;			//未实例化
		
		a.setA1("Aa");
		b = a;						//b引用a的实例，即将b的制证指向a相同的内存空间，a与b使用同一内存空间存放数据
		System.out.println("a.A1="+a.getA1()+",b.A1="+b.getA1());
		System.out.println("a == b ："+ (a==b)); //当两个引用变量指向同一实例时(即使用相同内存空间)才相等
		
		b.setA1("Ab");				//b修改了共同空间中的值，改值同样影响a
		System.out.println("a.A1="+a.getA1()+",b.A1="+b.getA1());
		
		a = new YinyongT();			//a重新实例化，放弃原内存空间，但原内存仍有b的指向，所以b使用原内存空间中值
		a.setA1("Ac");				//a对新空间中的数据进行变更，不会影响b
		System.out.println("a.A1="+a.getA1()+",b.A1="+b.getA1());
	}
}

class YinyongT{
	private String A1; //封装类

	public String getA1() {
		return this.A1;
	}

	public void setA1(String a1) {
		this.A1 = a1;
	}
	
}