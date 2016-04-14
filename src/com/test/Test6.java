/**
 * Project Name: MyTest
 * File Name:	 Test6.java
 * Package Name: com.test
 * Date:		 2014-11-19上午9:47:42
 * Copyright (c) 2014, zhaofei466@163.com All Rights Reserved.
 *
*/

package com.test;
/**
 * ClassName:Test6 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2014-11-19 上午9:47:42 <br/>
 * @author   zf
 * @version  
 * @see 	 
 */
public class Test6 {
	static int a = 2;
	static int b = 3;
	public static void main(String[] args) {
		change(a, b);
		System.out.println(a);
		System.out.println(b);
	}
	
	private static void change(int a, int b) {
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println(a);
		System.out.println(b);
	}
}

