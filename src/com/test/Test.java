package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
	@SuppressWarnings("unchecked")
	public static void main (String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Matt");
		list.add("dongji");
		list.add("Jobs");
		list.add("feng");
		Collections.sort(list, new MyCompre());
		for (String str:list) {
			System.out.println(str);
		}
		
	}
	 
	@SuppressWarnings("rawtypes")
	private static class MyCompre implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			String a = o1.toString();
			String b = o2.toString();
			return a.compareTo(b);
		}
		
	}
}
