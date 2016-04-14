/**
 * Project Name: MyTest
 * File Name:	 Test9.java
 * Package Name: com.test
 * Date:		 2016-1-26上午9:09:55
 * Copyright (c) 2016, zhaofei466@163.com All Rights Reserved.
 *
*/

package com.test;

import java.math.BigDecimal;

/**
 * ClassName:Test9 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016-1-26 上午9:09:55 <br/>
 * @author   zf
 * @version   	 
 */
public class Test9 {

	public static void main (String[] args) {
		BigDecimal a = new BigDecimal("2");
		BigDecimal b = new BigDecimal("3");
		BigDecimal c = new BigDecimal("4");
		
		BigDecimal d = a.add(b.multiply(c));
		
		BigDecimal e = a.multiply(a).subtract(b.multiply(b));
		
		System.out.println(d.toString());
		System.out.println(e.toString());
	}
}

