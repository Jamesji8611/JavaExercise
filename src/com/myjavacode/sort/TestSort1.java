package com.myjavacode.sort;

public class TestSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {99,94,95,93,92,91,90,89,97,88};
		System.out.println("----����ǰ���飺");
		TestSort1.printArr(arr);
		
		TestSort1.printArr(TestSort1.sort(arr));
		
		
		
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
			System.out.print("--�����У� "+i +" ");
			TestSort1.printArr(arr);
		}
		return arr;		
	}

}
