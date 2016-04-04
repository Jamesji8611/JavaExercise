package com.threadtest;

public class ThreadExtendsImplementsTest {
	
	public static void main(String[] args){
		
		ExtendsThreadT et = new ExtendsThreadT();
		//et.start();//启动一个线程,导致run()方法的运行
		
		ImplementsRunnableT ir1 = new ImplementsRunnableT();
		ImplementsRunnableT ir2 = new ImplementsRunnableT();
		ir1.run();//这不是启动一个线程,而是运行一个方法,要待此方法完结后,才能顺序的向下进行
		System.out.println("此处运行完成ir1.run()方法");
		ir2.run();//等前面的ir1.run()结束,才可以轮到此步骤进行
		System.out.println("此处运行完成ir2.run()方法");
		Thread irt1 = new Thread(ir1);//创建一个Thread对象
		Thread irt2 = new Thread(ir2);//创建一个Thread对象
		irt1.start();//待ir2.run()运行结束后即启动一个线程,线程启动后不等线程结束,后面的步骤就会开始执行!!
		System.out.println("此处启动了一个线程irt1.start()方法");
		irt2.start();//irt1.start()运行后紧跟着就会启动此线程
		System.out.println("此处启动了一个线程irt2.start()方法");
		
	}
}

class ExtendsThreadT extends Thread{
	int times = 0;
	
	public void run(){
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello World! ");
		}
	}
}

class ImplementsRunnableT implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Runnable: Hello World! " + i++);
			if(i == 4) break;
		}
	}
	
}
