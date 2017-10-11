package com.myjavacode.sort;


public class TestSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {99,94,95,93,92,91,90,88,97,89};
		int i,j;
		for(i=0;i<10;i++) {
			if(i!=9) {
				System.out.println(arr[i] +", ");
			}else {
				System.out.println(arr[i]);
			}
		}
		for(i=8;i>=0;i--) {
			for(j=0;j<=i;j++) {
				if(arr[j]>arr[j+1]) {
					int tmp;
					tmp= arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println("----------≈≈–Ú∫Û---------");
		for(i=0;i<10;i++) {
			if(i!=9) {
				System.out.println(arr[i] +", ");
			}else {
				System.out.println(arr[i]);
			}
		}

	}

}
