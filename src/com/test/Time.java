/**
 * Project Name: MyTest
 * File Name:	 Time.java
 * Package Name: com.test
 * Date:		 2015-4-10上午9:08:44
 * Copyright (c) 2015, zhaofei466@163.com All Rights Reserved.
 *
*/

package com.test;

import java.util.Calendar;

/**
 * ClassName:Time <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015-4-10 上午9:08:44 <br/>
 * @author   zf
 * @version   	 
 */
public class Time {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTimeInMillis());
	}
}

