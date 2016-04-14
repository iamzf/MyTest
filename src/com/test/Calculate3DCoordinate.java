/**
 * Project Name: SitunePhoneLocation
 * File Name:	 Calculate3DCoordinate.java
 * Package Name: cn.situne.phonelocation.common
 * Date:		 2016-1-21下午4:54:20
 * Copyright (c) 2016, zhaofei466@163.com All Rights Reserved.
 *
*/

package com.test;
/**
 * ClassName:Calculate3DCoordinate <br/>
 * Date:     2016-1-21 下午4:54:20 <br/>
 * @author   zf
 * @version   	 
 */
public class Calculate3DCoordinate {

	private static double x1 = 91.6;
	private static double y1 = 29.5;
	private static double z1 = 92;
	private static double d1 = 115;
	
	private static double x2 = 66;
	private static double y2 = 26;
	private static double z2 = 41;
	private static double d2 = 136;
	
	private static double x3 = 0;
	private static double y3 = 95.1;
	private static double z3 = 58;
	private static double d3 = 152.5;
	
	private static double x4 = 30.3;
	private static double y4 = 123;
	private static double z4 = 21.5;
	private static double d4 = 129;
	
//	private static double x1 = 147.7;
//	private static double y1 = 195.0;
//	private static double z1 = 111.5;
//	private static double d1 = 398.107;
//	
//	private static double x2 = 267.0;
//	private static double y2 = 144.5;
//	private static double z2 = 73.6;
//	private static double d2 = 501.187;
//	
//	private static double x3 = 147.7;
//	private static double y3 = 368.0;
//	private static double z3 = 73.6;
//	private static double d3 = 446.683;
//	
//	private static double x4 = 147.7;
//	private static double y4 = 260.0;
//	private static double z4 = 73.6;
//	private static double d4 = 501.187;
	
	public static void main(String[] args) {
		String[] a = get3DCoordinate();
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
	}
	
	
	public static String[] get3DCoordinate () {
		double Z_FORMULA1 = 2*x3*y1 - 2*x3*y2 - 2*x2*y1 + 2*x2*y3 + 2*x1*y2 - 2*x1*y3;
		double Z_FORMULA2 = 2*x4*z1 - 2*x4*z2 - 2*x3*z1 + 2*x3*z2 - 2*x2*z3 + 2*x2*z4 + 2*x1*z3 - 2*x1*z4;
		double Z_FORMULA3 = (x2 - x1)*(Math.pow(d3, 2) - Math.pow(d4, 2) - Math.pow(x2, 2)
				+ Math.pow(x3, 2) - Math.pow(y2, 2) + Math.pow(y3, 2) - Math.pow(z2, 2)
				+ Math.pow(z3, 2));
		double Z_FORMULA4 = (x4 - x3)*(Math.pow(d1, 2) - Math.pow(d2, 2) - Math.pow(x1, 2)
				+ Math.pow(x2, 2) - Math.pow(y1, 2) + Math.pow(y2, 2) - Math.pow(z1, 2)
				+ Math.pow(z2, 2));
		double Z_FORMULA5 = (x2 - x1)*(2*y3 - 2*y4) - (x4 - x3)*(2*y1 - 2*y2);
		double Z_FORMULA6 = (x2 - x1)*(2*z2 - 2*z3) - (x3 - x2)*(2*z1 - 2*z2);
		double Z_FORMULA7 = (x2 - x1)*(Math.pow(d2, 2) - Math.pow(d3, 2) - Math.pow(x2, 2)
				+ Math.pow(x3, 2) - Math.pow(y2, 2) + Math.pow(y3, 2) - Math.pow(z2, 2)
				+ Math.pow(z3, 2))
				-
				(x3 - x2)*(Math.pow(d1, 2) - Math.pow(d2, 2) - Math.pow(x1, 2) + Math.pow(x2, 2)
						- Math.pow(y1, 2) + Math.pow(y2, 2) - Math.pow(z1, 2) + Math.pow(z2, 2));
		
		String[] targetCoordinate = new String[3];
		double xt;
		double yt;
		double zt;
		
		zt = (Z_FORMULA1 * Z_FORMULA3 - Z_FORMULA1 * Z_FORMULA4 + Z_FORMULA5 * Z_FORMULA7)/
				(Z_FORMULA1 * Z_FORMULA2 - Z_FORMULA5 * Z_FORMULA6);
		
		yt = (Z_FORMULA6 * zt + Z_FORMULA7)/Z_FORMULA1;
		
		xt = ((2*y1 - 2*y2)*yt + (2*z1 - 2*z2)*zt + Math.pow(d1, 2) - Math.pow(d2, 2) - Math.pow(x1, 2)
				+ Math.pow(x2, 2) - Math.pow(y1, 2) + Math.pow(y2, 2) - Math.pow(z1, 2)
				+ Math.pow(z2, 2))/(2*x2 - 2*x1);
		
		targetCoordinate[0] = String.valueOf(xt);
		targetCoordinate[1] = String.valueOf(yt);
		targetCoordinate[2] = String.valueOf(zt);
		
		return targetCoordinate;
	}
}

