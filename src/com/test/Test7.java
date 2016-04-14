/**
 * Project Name: MyTest
 * File Name:	 Test7.java
 * Package Name: com.test
 * Date:		 2015-8-28下午4:05:15
 * Copyright (c) 2015, zhaofei466@163.com All Rights Reserved.
 *
*/

package com.test;
/**
 * ClassName:Test7 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015-8-28 下午4:05:15 <br/>
 * @author   zf
 * @version   	 
 */
public class Test7 {
	public static void main (String[] args) {
		int a = -60;
		System.out.println((a & 0xc4));
		System.out.println((double)(a & 0xc4)/255);
		System.out.println(String.valueOf((double)(a & 0xc4)/255*1.25*3));
	}
}

