package com.beanTest;

import java.util.ArrayList;

public class BeanTest {
	public static void main(String[] args){
		ArrayList<TestBean> ar = new ArrayList<TestBean>();
		TestBean tb = new TestBean();
		
		for(int i=0; i<10; i++){
			tb = new TestBean();
			//ArrayList�д洢����object���ñ���,��˱���ÿ�ζ�����newһ��ʵ��,
			//�����²�������ֵ�൱�ڸ�����ͬһ����ַ����һ��ֵ!!!!!���ñ���С��,����ָ��һ��!!!!
			tb.setTmp1(i);
			System.out.println("TestBean.getTmp1() = " +tb.getTmp1());
			ar.add(tb);
			for(int j=0; j<ar.size(); j++){
				System.out.println("ar[" + j + "] =" + ar.get(j).getTmp1());
			}
		}
		
	}
}
