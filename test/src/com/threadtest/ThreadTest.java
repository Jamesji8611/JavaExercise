package com.threadtest;
import java.lang.*;

public class ThreadTest {
	public static void main(String[] args){
		ThreadT t = new ThreadT();
		ThreadT1 t1 = new ThreadT1();
		t.start(); //����һ���߳� //new ThreadT().start();//����д�������ʽ
		t.run();//������ͨ����ִ��
		t1.runT(); //һ����ͨ���е���ͨ��������Ȼ����ʹ��Thread.sleep()������
		//������ͨ����ִ��ʱ��Ҫ��ִ�����t.run(),��˳��ִ�к�������
		//��ʱ�൱�����������̣߳�һ�����߳���˳��ִ��main�еĸ�������һ��ThreadT.start()�̣߳�����main����
		ThreadT2 t2 = new ThreadT2(); //ʵ����
		t2.run();//����һ����ͨ�ķ��������÷���ִ�н������˳��ִ�к���������
		new Thread(t2).start();
		//new Thread(t1).start(); //��ͨ��(û�м̳�Thread��ʵ��Runnable)������ʹ��Thread.start() ��������
		//��Runnable�ӿ���û�ж���start�����������Զ�����Ҳû��ȥʵ��������������Ա���ͨ��Thread�౾���������̣߳�����
		for(int i = 0;i<3;i++){
			try {
				Thread.sleep(300);//��Ȼmainû�м̳�thread�����൱��һ�����̣�Ҳ��ʹ��Thread.sleep()��������������
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�����������е�main����������"+i+" �߳����ƣ�"+ Thread.currentThread().getName());
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
			System.out.println("����һ���߳������У�"+i+" �߳����ƣ�"+ Thread.currentThread().getName());
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
			System.out.println("��������һ����ͨ����ͷ���������������"+i+" �߳����ƣ�"+ Thread.currentThread().getName());
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
			System.out.println("ͨ��Runnable�ӿ�ʵ������̣߳�����������"+i+" �߳����ƣ�"+ Thread.currentThread().getName());
		}
	}
	
}