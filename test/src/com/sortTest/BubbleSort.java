package com.sortTest;

public class BubbleSort extends Sort {

	/**
	 * 功能:冒泡排序
	 * @param args
	 */
	private double tmp = 0;
	private int Num = 0;
	public int getNum() {
		return Num;
	}

	public void bubbleS(double[] arr){
		for(int i = 0; i < arr.length-1; i++){
			for(int j = 0; j < arr.length - i - 1; j++){
				/*
				 * 每次将一个数与后面的数进行比较,并向后交换数值较大的数,
				 * 当后面的数大于当前数时,当前数值在本次比较中终止,后面较大的数继续
				 */
				Num++; //比较的次数!
				if(arr[j] > arr[j+1]){
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//double[] arr = new double[10];
		double[] arr = {10,9,23,7,9,8,15,-1,0,8};
		
		BubbleSort bs = new BubbleSort();
		bs.show(arr);
		bs.bubbleS(arr);
		System.out.println("排序过程中比较的次数: " + bs.getNum());
		bs.show(arr);
	}
	

}
