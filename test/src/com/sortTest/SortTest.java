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
		System.out.println("冒泡排序:");
		System.out.println("开始时间" + Calendar.getInstance().getTime());
		bs.bubbleS(arr.getArr());
		System.out.println("结束时间" + Calendar.getInstance().getTime());
		
		System.out.println("选择排序:");
		System.out.println("开始时间" + Calendar.getInstance().getTime());
		ss.selectS(arr.getArr());
		System.out.println("结束时间" + Calendar.getInstance().getTime());
		
		System.out.println("插入排序:");
		System.out.println("开始时间" + Calendar.getInstance().getTime());
		is.insertionS(arr.getArr());
		System.out.println("结束时间" + Calendar.getInstance().getTime());
		*******************************************************************/
		
		System.out.println("快速排序:");
		System.out.println("开始时间" + Calendar.getInstance().getTime());
		qs.quickS(0, arr.getArr().length -1, arr.getArr());
		System.out.println("结束时间" + Calendar.getInstance().getTime());
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