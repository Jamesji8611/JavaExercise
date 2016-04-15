package com.beanTest;

import java.util.ArrayList;

public class BeanTest {
	public static void main(String[] args){
		ArrayList<TestBean> ar = new ArrayList<TestBean>();
		TestBean tb = new TestBean();
		
		for(int i=0; i<10; i++){
			tb = new TestBean();
			//ArrayList中存储的是object引用变量,因此必须每次都重新new一个实例,
			//否则新产生的数值相当于覆盖了同一个地址的上一个值!!!!!引用变量小心,就像指针一样!!!!
			tb.setTmp1(i);
			System.out.println("TestBean.getTmp1() = " +tb.getTmp1());
			ar.add(tb);
			for(int j=0; j<ar.size(); j++){
				System.out.println("ar[" + j + "] =" + ar.get(j).getTmp1());
			}
		}
		
	}
}
