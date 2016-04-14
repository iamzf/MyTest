/**
 * Project Name: MyTest
 * File Name:	 Test5.java
 * Package Name: com.test
 * Date:		 2014-10-22下午2:01:37
 * Copyright (c) 2014, zhaofei466@163.com All Rights Reserved.
 *
 */

package com.test;

/**
 * ClassName:Test5 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2014-10-22 下午2:01:37 <br/>
 * 
 * @author zf
 * @version
 * @see
 */
public class Test5 {
	
	public static void main(String[] args) {
		System.out.println(invoke(0));
	}
	
	public static final int invoke(int i) {
		try {
			i++;
			throw new Exception();
		} catch (Exception e) {
			return i;
		} finally {
			System.out.println(++i);
		}
	}

}
