package com.sortTest;

public class BubbleSort extends Sort {

	/**
	 * ����:ð������
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
				 * ÿ�ν�һ���������������бȽ�,����󽻻���ֵ�ϴ����,
				 * ������������ڵ�ǰ��ʱ,��ǰ��ֵ�ڱ��αȽ�����ֹ,����ϴ��������
				 */
				Num++; //�ȽϵĴ���!
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
		System.out.println("��������бȽϵĴ���: " + bs.getNum());
		bs.show(arr);
	}
	

}
