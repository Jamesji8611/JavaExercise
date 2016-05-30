package com.xml;

class demo {
	public void method(){
		System.out.println("Method1");
	}
	public void method(int i){
		System.out.println("Overload Method2 i=" +i);
	}
	public void method(int i, int j){
		System.out.println("Overload Method3 i=" +i + " ,j=" +j);
	}
	public void doStuff(){
		
	}
}

class a extends demo{
	public void doStuff(){
		super.doStuff();
	}
}
