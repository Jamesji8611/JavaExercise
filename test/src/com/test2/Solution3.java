package com.test2;

public class Solution3 {
	int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else {
                l = m;
                /*if (A[l] == X) {
                    return l;
                }*/
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
	public static void main(String[] args) {		
		int[] a ={1, 2, 5, 9, 9};
		Solution3 b = new Solution3();
		System.out.println(b.solution(a, 5));

	}

}
