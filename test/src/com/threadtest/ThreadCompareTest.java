package com.threadtest;

public class ThreadCompareTest {
	public static void main(String[] args) throws Exception{
		ExtendsThread t = new ExtendsThread();
		t.start(); 
		//t.start();
		//这样对一个实例启用两次start() 时会报错！！！！
		Thread.sleep(5000);//休眠
		System.out.println("*******第一个例子结束**********");
		new ExtendsThread().start();
		new ExtendsThread().start();
		//这样相当于两个实例在启动线程，操作对象之间不共享数据！！
		Thread.sleep(5000);//休眠
		System.out.println("*******第二个例子结束**********");
		ImplementsRunnable t1 = new ImplementsRunnable(20);
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
		//相当于两个线程在对一个对象进行操作，线程会相互强资源！
		Thread t2 = Thread.currentThread();
	}
}
class ExtendsThread extends Thread{
	private int Num = 5;
	public void run(){
		while(Num>0){
			System.out.println("ExtendsThread对象 进程 "+Thread.currentThread().getName()+" 对Num进行操作，Num="+Num);
			Num--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class ImplementsRunnable implements Runnable{
	private int Num;
	public ImplementsRunnable(int Num){
		this.Num = Num;
	}
	public synchronized void run(){ //方法同步 同一时间内只有一个线程执行此方法！
		//synchronized(this){ //同步 同一时间内只能有一个线程操作此段代码
			while(Num>0){
				System.out.println("ImplementsRunnable对象 进程 "+Thread.currentThread().getName()+" 对Num进行操作，Num="+Num);
				Num--;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//}
	}
}