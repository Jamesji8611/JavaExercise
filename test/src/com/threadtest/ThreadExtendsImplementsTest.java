package com.threadtest;

public class ThreadExtendsImplementsTest {
	
	public static void main(String[] args){
		
		ExtendsThreadT et = new ExtendsThreadT();
		//et.start();//����һ���߳�,����run()����������
		
		ImplementsRunnableT ir1 = new ImplementsRunnableT();
		ImplementsRunnableT ir2 = new ImplementsRunnableT();
		ir1.run();//�ⲻ������һ���߳�,��������һ������,Ҫ���˷�������,����˳������½���
		System.out.println("�˴��������ir1.run()����");
		ir2.run();//��ǰ���ir1.run()����,�ſ����ֵ��˲������
		System.out.println("�˴��������ir2.run()����");
		Thread irt1 = new Thread(ir1);//����һ��Thread����
		Thread irt2 = new Thread(ir2);//����һ��Thread����
		irt1.start();//��ir2.run()���н���������һ���߳�,�߳������󲻵��߳̽���,����Ĳ���ͻῪʼִ��!!
		System.out.println("�˴�������һ���߳�irt1.start()����");
		irt2.start();//irt1.start()���к�����žͻ��������߳�
		System.out.println("�˴�������һ���߳�irt2.start()����");
		
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
