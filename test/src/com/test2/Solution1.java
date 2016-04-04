package com.test2;

public class Solution1 {
	public int solution1(int M, int N) {
        // write your code in Java SE 8
		int c = M;
		for(int i=M+1; i<=N; i++){
			c = c&i;
		}
		return c;
		// If M == N, then the result of M bitand N is still M!
    }
	
	public static void main(String[] args){
		Solution1 a = new Solution1();
		System.out.println(a.solution1(5, 7));
		System.out.println(a.solution1(12, 17));
	}
}
