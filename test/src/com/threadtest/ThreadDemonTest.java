package com.threadtest;

public class ThreadDemonTest {
	public static void main(String[] args) throws Exception{
		ThreadDemonT t = new ThreadDemonT();
		//new Thread(t).start();
		//Thread.sleep(3000);
		Thread t1 = new Thread(t);
		t1.setDaemon(true);
		t1.start();
	}
}
class ThreadDemonT implements Runnable{
	private int i = 5;
	public void run(){
		while(i>0){
			System.out.println(Thread.currentThread().getName() +" 是一个后台线程！");
			i--;
		}
	}
}
