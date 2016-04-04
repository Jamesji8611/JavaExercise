package com.threadtest;

public class ThreadCompareTest {
	public static void main(String[] args) throws Exception{
		ExtendsThread t = new ExtendsThread();
		t.start(); 
		//t.start();
		//������һ��ʵ����������start() ʱ�ᱨ��������
		Thread.sleep(5000);//����
		System.out.println("*******��һ�����ӽ���**********");
		new ExtendsThread().start();
		new ExtendsThread().start();
		//�����൱������ʵ���������̣߳���������֮�䲻�������ݣ���
		Thread.sleep(5000);//����
		System.out.println("*******�ڶ������ӽ���**********");
		ImplementsRunnable t1 = new ImplementsRunnable(20);
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
		new Thread(t1).start();
		//�൱�������߳��ڶ�һ��������в������̻߳��໥ǿ��Դ��
		Thread t2 = Thread.currentThread();
	}
}
class ExtendsThread extends Thread{
	private int Num = 5;
	public void run(){
		while(Num>0){
			System.out.println("ExtendsThread���� ���� "+Thread.currentThread().getName()+" ��Num���в�����Num="+Num);
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
	public synchronized void run(){ //����ͬ�� ͬһʱ����ֻ��һ���߳�ִ�д˷�����
		//synchronized(this){ //ͬ�� ͬһʱ����ֻ����һ���̲߳����˶δ���
			while(Num>0){
				System.out.println("ImplementsRunnable���� ���� "+Thread.currentThread().getName()+" ��Num���в�����Num="+Num);
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