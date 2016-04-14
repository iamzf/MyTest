/**
 * Project Name: MyTest
 * File Name:	 DBHelper.java
 * Package Name: com.test
 * Date:		 2015-6-11上午9:16:13
 * Copyright (c) 2015, zhaofei466@163.com All Rights Reserved.
 *
*/

package com.test;

import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * ClassName:DBHelper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2015-6-11 上午9:16:13 <br/>
 * @author   zf
 * @version   	 
 */
public class DBHelper {

//	public static final String url = "jdbc:mysql://121.199.23.149/itee";
	public static final String url = "jdbc:mysql://localhost/mytest";
	public static final String name = "com.mysql.jdbc.Driver";
//	public static final String user = "zhaofei";
	public static final String user = "root";
//	public static final String password = "123456";
	public static final String password = "root";
	
	public java.sql.Connection conn = null;
	
	public DBHelper () {
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}

