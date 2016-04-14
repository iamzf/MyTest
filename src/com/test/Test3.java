
package com.test;
/**
 * 
 * ClassName: 	Test3 <br/>
 * Function: 	TODO ADD FUNCTION. <br/>
 * Reason: 		TODO ADD REASON(可选). <br/>
 * date: 		2014-8-22 下午1:34:22 <br/>
 *
 * @author 		zf
 * @version
 */
public class Test3 {
	private String a = ";";
	public static void main(String[] args) {
		String str = "1,,";
		String[] sts = str.split(",");
		System.out.println(sts.length);// world
		for(String string : sts){
			// world
			System.out.println(string);/* world */
		}
	}
}	
