package com.test2.javatest;

public class InitializeTest {
	public static void main(String[] args){
		Leaf a = new Leaf();
		Leaf b = new Leaf();
		a.printF();
		b.printF();
		Test t = new Test();
		System.out.println(t.t);
	}
}

class Root{
	
	public int root = 9;
	public static int staticRoot = 10;
	//System.out.println("���е�ִ�����ֻ���ڷ����л��ʼ������ִ��");
	
	static{ //��̬��ʼ��
		staticRoot = 101;
		System.out.println("Root �ľ�̬��ʼ��" + " staticRoot=" + staticRoot);
	}
	{//��ͨ��ʼ����
		root = 99;
		staticRoot = 1010;
		System.out.println("Root ����ͨ��ʼ��" + "root=" + root + " staticRoot=" + staticRoot);
	}
	
	public Root(){
		System.out.println("Root ���޲ι��췽��" + " root=" + root + " staticRoot" + staticRoot);
	}//��̬�����;�̬��ʼ�����в��ܵ��÷Ǿ�̬��Ա���Ǿ�̬�����ͷǾ�̬��ʼ�����п��Ե��þ�̬��Ա�ͷǾ�̬��Ա
	public void printF(){
		System.out.println("root=" + root + " staticRoot=" + staticRoot);
	}
	
}
class Mid extends Root{
	static{
		System.out.println("Mid �ľ�̬��ʼ����");
	}
	{
		System.out.println("Mid ����ͨ��ʼ����");
	}
	public Mid(){
		System.out.println("Mid ���޲������췽��");
	}
	public Mid(String a){
		this();
		System.out.println("Mid ���в������췽�� " + a + " root=" + root + " staticRoot=" + staticRoot);
	}
}
class Leaf extends Mid{
	static{
		System.out.println("Leaf �ľ�̬��ʼ����");
	}
	{
		System.out.println("Leaf �ķǾ�̬��ʼ����");
	}
	public Leaf(){
		super("Hello Initialize");
		System.out.println("Leaf ���޲������췽��");
	}
}
class Test{
	static{
		t =99;
	}
	static int t = 9;
}