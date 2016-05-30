package com.random;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args){
		Random r = new Random();
		
		char[] c = {'2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z'};
		System.out.println("c.length = " + c.length);
		System.out.println("Random = " + r.nextInt(c.length));
		StringBuffer st = new StringBuffer();
		for(int i = 0; i < 6; i++){
			st.append(c[r.nextInt(c.length)]);
		}
		System.out.println(st);
		
	}
}
