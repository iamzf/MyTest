/**
 * Project Name: MyTest
 * File Name:	 HashMapClone.java
 * Package Name: com.test
 * Date:		 2016-2-29上午9:25:33
 * Copyright (c) 2016, zhaofei466@163.com All Rights Reserved.
 *
*/

package com.test;

import java.util.HashMap;

/**
 * ClassName:HashMapClone <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016-2-29 上午9:25:33 <br/>
 * @author   zf
 * @version   	 
 */
public class HashMapClone {
	public static void main(String args[]) {
		HashMap map1 = null;
		HashMap map2 = new HashMap();
		map2.put("1", "Hello");map2.put("2", "World");
		map1 =(HashMap)map2.clone();
		System.out.println(map1);
		System.out.println(map2);
		map1.put("1",(String)map1.get("1") + "World");
		System.out.println(map1);
		System.out.println(map2);
	}
}

