package com.sortTest;

public class QuickSort extends Sort{

	/**
	 * @param args
	 */
	public void quickS(int left, int right, double[] arr){
		int l = left;
		int r = right;
		double pivot = arr[(left + 	right)/2];
		double tmp = 0;
		
		while(l<r){
			while(arr[l] < pivot) l++;
			while(arr[r] > pivot) r--;
			
			if(l >= r) break;
			tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
			
			if(arr[l] == pivot) --r;
			if(arr[r] == pivot) ++l;
		}
		
		if(l == r){
			l++;
			r--;
		}
		
		if(left < r) quickS(left, r, arr);
		if(right > l) quickS(l, right, arr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] arr = {10,9,23,7,9,8,15,-1,0,8};
		
		QuickSort qs = new QuickSort();
		qs.show(arr);
		qs.quickS(0, arr.length-1, arr);
		//System.out.println("排序过程中比较的次数: " + ss.getNum());
		qs.show(arr);
	}

}
