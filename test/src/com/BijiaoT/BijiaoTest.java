package com.BijiaoT;
/**
 * 
 * @author James
 * @funciton Test
 *
 */


public class BijiaoTest {
	public static void main(String[] args){
		BijiaoT T1 = new BijiaoT("T",1);
		BijiaoT T2 = new BijiaoT("T",1);
		BijiaoT T3 = T1;
		
		System.out.println("T1 "+((T1==T2)?"==":"!=")+" T2");
		System.out.println("T1 "+((T1.equals(T2))?"equals":"not equals")+" T2"); //������Ϊ��T1 not equals T2
		//equals �����Ƚϸ��ӣ����ܵ�������Ϊequals�ǱȽ������������ݵģ�����
		System.out.println("T1 "+((T1==T3)?"==":"!=")+" T3");
	}
}

class BijiaoT{
	String Name;
	int age;
	BijiaoT(String Name,int age){
		this.Name = Name;
		this.age = age;
	}
}