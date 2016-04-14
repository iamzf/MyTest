package com.test;

import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Compre {
	@SuppressWarnings("unchecked")
	public static void main (String[] args) {
		List<NoGroupPlayerVo> list = new ArrayList<NoGroupPlayerVo>();
		NoGroupPlayerVo vo1 = new NoGroupPlayerVo();
		vo1.name = "尤文";
		NoGroupPlayerVo vo2 = new NoGroupPlayerVo();
		vo2.name = "刘德华";
		NoGroupPlayerVo vo3 = new NoGroupPlayerVo();
		vo3.name = "高于";
		NoGroupPlayerVo vo4 = new NoGroupPlayerVo();
		vo4.name = "白本本";
		NoGroupPlayerVo vo5 = new NoGroupPlayerVo();
		vo5.name = "菜青虫";
		NoGroupPlayerVo vo6 = new NoGroupPlayerVo();
		vo6.name = "aa";
		NoGroupPlayerVo vo7 = new NoGroupPlayerVo();
		vo7.name = "boy";
		NoGroupPlayerVo vo8 = new NoGroupPlayerVo();
		vo8.name = "1";
		NoGroupPlayerVo vo9 = new NoGroupPlayerVo();
		vo9.name = "2";
		NoGroupPlayerVo vo10 = new NoGroupPlayerVo();
		vo10.name = "B";
		NoGroupPlayerVo vo11 = new NoGroupPlayerVo();
		vo11.name = "AAAA";
		NoGroupPlayerVo vo12 = new NoGroupPlayerVo();
		vo12.name = "彭碰碰";
		NoGroupPlayerVo vo13 = new NoGroupPlayerVo();
		vo13.name = "T1";
		NoGroupPlayerVo vo14 = new NoGroupPlayerVo();
		vo14.name = "T2";
		list.add(vo1);
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		list.add(vo5);
		list.add(vo6);
		list.add(vo7);
		list.add(vo8);
		list.add(vo9);
		list.add(vo10);
		list.add(vo11);
		list.add(vo12);
		list.add(vo13);
		list.add(vo14);
		
		MyCompare compare = new MyCompare();
		Collections.sort(list, compare);
		
		for (NoGroupPlayerVo vo: list) {
			System.out.println(vo.name);
		}
		
	}
	@SuppressWarnings("rawtypes")
	public static class MyCompare implements Comparator{
		public MyCompare(){
			
		}
		private Collator collator = Collator.getInstance(Locale.CHINA);
		@Override
		public int compare(Object o1, Object o2) {
			NoGroupPlayerVo vo1 = (NoGroupPlayerVo) o1;
			NoGroupPlayerVo vo2 = (NoGroupPlayerVo) o2;
			CollationKey key1 = collator.getCollationKey(vo1.name.toLowerCase());
			CollationKey key2 = collator.getCollationKey(vo2.name.toLowerCase());
			
			return key1.compareTo(key2);
		}
		
	}
}
