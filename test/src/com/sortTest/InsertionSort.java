package com.sortTest;

public class InsertionSort extends Sort{

	/**
	 * @param args
	 * 
	 */
	public void insertionS(double[] arr){
		for(int i = 1; i < arr.length; i++){
			double insertVal = arr[i];
			int index = i - 1;
			while(index>=0 && (insertVal < arr[index])){
				arr[index + 1] = arr[index];
				index--;
			}
			arr[index+1] = insertVal;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] arr = {10,9,23,7,9,8,15,-1,0,8};
		
		InsertionSort is = new InsertionSort();
		is.show(arr);
		is.insertionS(arr);
		//System.out.println("排序过程中比较的次数: " + ss.getNum());
		is.show(arr);

	}

}
