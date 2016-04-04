package com.sortTest;

import java.util.Calendar;
import java.lang.Math;

public class SortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort bs = new BubbleSort();
		SelectionSort ss = new SelectionSort();
		InsertionSort is = new InsertionSort();
		QuickSort qs = new QuickSort();
		CreatArr arr = new CreatArr(500000);
		
		/***************************************************************
		System.out.println("ð������:");
		System.out.println("��ʼʱ��" + Calendar.getInstance().getTime());
		bs.bubbleS(arr.getArr());
		System.out.println("����ʱ��" + Calendar.getInstance().getTime());
		
		System.out.println("ѡ������:");
		System.out.println("��ʼʱ��" + Calendar.getInstance().getTime());
		ss.selectS(arr.getArr());
		System.out.println("����ʱ��" + Calendar.getInstance().getTime());
		
		System.out.println("��������:");
		System.out.println("��ʼʱ��" + Calendar.getInstance().getTime());
		is.insertionS(arr.getArr());
		System.out.println("����ʱ��" + Calendar.getInstance().getTime());
		*******************************************************************/
		
		System.out.println("��������:");
		System.out.println("��ʼʱ��" + Calendar.getInstance().getTime());
		qs.quickS(0, arr.getArr().length -1, arr.getArr());
		System.out.println("����ʱ��" + Calendar.getInstance().getTime());
	}
}

class CreatArr{
	private double[] arr;
	
	public double[] getArr() {
		return arr;
	}

	public CreatArr(int Num){
		arr = new double[Num];
		for(int i = 0; i < Num; i++){
			arr[i] = Math.random()*100*Math.random();
		}
	}
}