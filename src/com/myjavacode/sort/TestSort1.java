package com.myjavacode.sort;

import java.util.Random;

public class TestSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {99,94,95,93,92,91,90,89,97,88};
		int arr1[] = TestSort1.createArr(1000); //随机产生数组
		System.out.println("----排序前数组：");
		TestSort1.printArr(arr1);
		
		TestSort1.printArr(TestSort1.sort(arr1));
		
		
		
	}
	
	public static void printArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if(i!=(arr.length-1))
				System.out.print(" ,");
			else
				System.out.println("");
		}
	}
	
	public static int[] sort(int[] arr) {
		for(int i=arr.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				int tmp = 0;
				if(arr[j] > arr[j+1]) {
					tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
			System.out.print("--排序中： "+i +" ");
			TestSort1.printArr(arr);
		}
		return arr;		
	}
	
	public static int[] createArr(int i) {
		int[] arr = new int[i];
		Random ran = new Random();
		for(int j=0; j<i; j++) {
			arr[j] = ran.nextInt(1000000);
		}
		
		return arr;
	}

}
