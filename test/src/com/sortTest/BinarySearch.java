package com.sortTest;

public class BinarySearch extends Sort{

	/**
	 * @param args
	 */
	
	public int binaryS(double[] arr, int leftIndex, int rightIndex, double val){
		int midIndex = (leftIndex + rightIndex)/2;
		double midVal = arr[midIndex];
		
		if(rightIndex >= leftIndex){
			if(midVal > val){
				binaryS(arr, leftIndex, midIndex-1, val);
			}else if(midVal < val){
				binaryS(arr, midIndex+1, rightIndex, val);
			}else if(midVal == val){
				System.out.println( "已找到要查找的数据"+ val + " 坐标" + midIndex);
				return 0;
			}
		}
		//return "未找到要查找的数据" + val +" !!!";
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] arr = {10,9,23,7,9,8,15,-1,0,8};
				
		QuickSort qs = new QuickSort();
		qs.quickS(0, arr.length-1, arr);
		qs.show(arr);
		
		BinarySearch bs = new BinarySearch();
		//bs.binaryS(arr, 0, arr.length-1, 23);
		System.out.println(bs.binaryS(arr, 0, arr.length-1, 0));
	}

}
