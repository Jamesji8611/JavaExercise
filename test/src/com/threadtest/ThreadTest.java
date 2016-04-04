package com.threadtest;
import java.lang.*;

public class ThreadTest {
	public static void main(String[] args){
		ThreadT t = new ThreadT();
		ThreadT1 t1 = new ThreadT1();
		t.start(); //启动一个线程 //new ThreadT().start();//或者写成这个形式
		t.run();//按照普通方法执行
		t1.runT(); //一个普通类中的普通方法，依然可以使用Thread.sleep()方法！
		//按照普通方法执行时需要先执行完成t.run(),再顺序执行后面的语句
		//此时相当于启动两个线程，一个主线程在顺序执行main中的各方法，一个ThreadT.start()线程，在与main并发
		ThreadT2 t2 = new ThreadT2(); //实例化
		t2.run();//仍是一个普通的方法，待该方法执行结束后才顺序执行后续操作！
		new Thread(t2).start();
		//new Thread(t1).start(); //普通类(没有继承Thread和实现Runnable)不可以使用Thread.start() 方法！！
		//因Runnable接口中没有定义start方法，我们自定类中也没有去实现这个方法，所以必须通过Thread类本身来启动线程！！！
		for(int i = 0;i<3;i++){
			try {
				Thread.sleep(300);//虽然main没有继承thread，但相当于一个进程，也可使用Thread.sleep()方法来控制休眠
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("这是主进程中的main方法在运行"+i+" 线程名称："+ Thread.currentThread().getName());
		}
	}
}
class ThreadT extends Thread{
	public void run(){
		for(int i=0;i<3;i++){
			/**/
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/**/
			System.out.println("这是一个线程在运行！"+i+" 线程名称："+ Thread.currentThread().getName());
		}
	}
}
class ThreadT1{
	public void runT(){
		for(int i=0;i<3;i++){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("！！！！一个普通的类和方法！！！！！！"+i+" 线程名称："+ Thread.currentThread().getName());
		}
		
	}
}
class ThreadT2 implements Runnable{
	public void run(){
		for(int i=0;i<3;i++){
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("通过Runnable接口实现完成线程！！！！！！"+i+" 线程名称："+ Thread.currentThread().getName());
		}
	}
	
}