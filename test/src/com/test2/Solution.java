package com.test2;

public class Solution {
	
	public int solution(int[] A) {
        // write your code in Java SE 8
		for(int i=0; i< A.length; i++){
			double sumL = 0.0;
			double sumR = 0.0;
			for(int j=0; j<i; j++){
				sumL += A[j];
			}
			for(int k=i+1; k<A.length; k++){
				sumR += A[k];
			}
			if(sumL == sumR){
				return i;
			}
		}
		return -1;
    }
	
	public static void main(String[] args){
		int[] A={-7,1,5,2,-4,3,0};
		int[] B={-1, 3, -4, 5, 1, -6, 2, 1};
		Solution a1 = new Solution();
		//System.out.println(a1.solution(A));
		//System.out.println(a1.solution(B));
		
	}
}
