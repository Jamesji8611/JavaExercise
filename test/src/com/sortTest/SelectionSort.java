package com.sortTest;

public class SelectionSort extends Sort{

	/**����: ѡ������
	 * @param args
	 * ��ÿһ��������ѡȡarr.length -i ������С��һ����i����λ��
	 */
	private double tmp = 0;
	private int Num = 0;
	public int getNum() {
		return Num;
	}
	
	public void selectS(double[] arr){
		
		for(int i = 0; i < arr.length-1; i++){
			double min = arr[i];
			int minIndex = i;
			
			for(int j = i+1; j< arr.length; j++){
				Num++;
				if(min > arr[j]){
					min = arr[j];
					minIndex = j;
				}
			}
			
			tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] arr = {10,9,23,7,9,8,15,-1,0,8};
		
		SelectionSort ss = new SelectionSort();
		ss.show(arr);
		ss.selectS(arr);
		System.out.println("��������бȽϵĴ���: " + ss.getNum());
		ss.show(arr);
	}

}
