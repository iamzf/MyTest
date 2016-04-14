package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	
	
	public static void main (String[] args) {
		String str = "azuregolf.com";
		if (!isIP(str)) {
			if(!isDomainName(str)) {
				System.out.println("false");
			} else {
				System.out.println("true");
			}
		} else {
			System.out.println("true");
		}
	}
	
	public static boolean isDomainName(String str) {
		String regex = "^(http(s)?://)?(([a-zA-z0-9]|-){1,}\\.){1,}(([a-zA-z0-9]|-){1,}\\.){1,}(com|org|net|mil|edu)(\\.cn)?$";
//		String regex = "^[a-z0-9_-]{2,}(\\.[a-z0-9_-]{2,})*\\.(com|org|net|mil|edu)\\.cn$";
//		String regex ="^http(s)?://([//w-]+//.)+[//w-]+(/[//w- ./?%&=]*)?$";
//		"^[a-z]+$"
		return match(regex, str);
	}
	
	public static boolean isIP(String str) {
		String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
		String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
		return match(regex, str);
	}
	
	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}
