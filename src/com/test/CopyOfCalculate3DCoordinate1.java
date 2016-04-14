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
public class CopyOfCalculate3DCoordinate1 {

	private static float x1 = 91.6f;
	private static float y1 = 29.5f;
	private static float z1 = 92f;
	private static float d1 = 115f;
	
	private static float x2 = 66f;
	private static float y2 = 26f;
	private static float z2 = 41f;
	private static float d2 = 136f;
	
	private static float x3 = 0f;
	private static float y3 = 95.1f;
	private static float z3 = 58f;
	private static float d3 = 152.5f;
	
	private static float x4 = 30.3f;
	private static float y4 = 123f;
	private static float z4 = 21.5f;
	private static float d4 = 129f;
	
	public static void main(String[] args) {
		float[] a = get3DCoordinate();
		System.out.println(String.valueOf(a[0]));
		System.out.println(String.valueOf(a[1]));
		System.out.println(String.valueOf(a[2]));
	}
	
	
	public static float[] get3DCoordinate () {
		float Z_FORMULA1 = setScale2(2*x3*y1 - 2*x3*y2 - 2*x2*y1 + 2*x2*y3 + 2*x1*y2 - 2*x1*y3);
		float Z_FORMULA2 = setScale2(2*x4*z1 - 2*x4*z2 - 2*x3*z1 + 2*x3*z2 - 2*x2*z3 + 2*x2*z4 + 2*x1*z3 - 2*x1*z4);
		float Z_FORMULA3 = setScale2((x2 - x1)*(Math.pow(d3, 2) - Math.pow(d4, 2) - Math.pow(x2, 2)
				- Math.pow(x3, 2) + Math.pow(y2, 2) - Math.pow(y3, 2) + Math.pow(z2, 2)
				- Math.pow(z3, 2)));
		float Z_FORMULA4 = setScale2((x4 - x3)*(Math.pow(d1, 2) - Math.pow(d2, 2) - Math.pow(x1, 2)
				- Math.pow(x2, 2) + Math.pow(y1, 2) - Math.pow(y2, 2) + Math.pow(z1, 2))
				- Math.pow(z2, 2));
		float Z_FORMULA5 = setScale2((x2 - x1)*(2*y3 - 2*y4) - (x4 - x3)*(2*y1 - 2*y2));
		float Z_FORMULA6 = setScale2((x2 - x1)*(2*z2 - 2*z3) - (x3 - x2)*(2*z1 - 2*z2));
		float Z_FORMULA7 = setScale2((x2 - x1)*(Math.pow(d2, 2) - Math.pow(d3, 2) - Math.pow(x2, 2)
				- Math.pow(x3, 2) + Math.pow(y2, 2) - Math.pow(y3, 2) + Math.pow(z2, 2)
				- Math.pow(z3, 2))
				-
				(x3 - x2)*(Math.pow(d1, 2) - Math.pow(d2, 2) - Math.pow(x1, 2) - Math.pow(x2, 2)
						+ Math.pow(y1, 2) - Math.pow(y2, 2) + Math.pow(z1, 2) - Math.pow(z2, 2)));
		
		float[] targetCoordinate = new float[3];
		float xt;
		float yt;
		float zt;
		
		zt = setScale2((Z_FORMULA1 * Z_FORMULA3 + Z_FORMULA1 * Z_FORMULA4 + Z_FORMULA5 * Z_FORMULA7)/
				(Z_FORMULA1 * Z_FORMULA2 - Z_FORMULA5 * Z_FORMULA6));
		
		yt = setScale2((Z_FORMULA6 * zt + Z_FORMULA7)/Z_FORMULA1);
		
		xt = setScale2(((2*y1 - 2*y2)*yt + (2*z1 - 2*z2)*zt + Math.pow(d1, 2) - Math.pow(d2, 2) - Math.pow(x1, 2)
				- Math.pow(x2, 2) + Math.pow(y1, 2) - Math.pow(y2, 2) + Math.pow(z1, 2)
				- Math.pow(z2, 2))/(2*x2 - 2*x1));
		
		targetCoordinate[0] = xt;
		targetCoordinate[1] = yt;
		targetCoordinate[2] = zt;
		
		return targetCoordinate;
	}
	
	public static float setScale2(double d) {
		return Math.round(d*100)/100f;
	}
}

