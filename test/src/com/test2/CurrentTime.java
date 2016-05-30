package com.test2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
	public static void main(String[] args){
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss SSSS");
		SimpleDateFormat dateformat1 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss SSSS");
		System.out.println("Current Time: " + dateformat.format(new Date()));
		System.out.println("Current Time: " + dateformat1.format(new Date()));
	}
}
