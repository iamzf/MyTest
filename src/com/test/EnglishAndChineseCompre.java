package com.test;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

public class EnglishAndChineseCompre {
	private static String pinyinName = "";

	/**
	 * 汉字转拼音的方法
	 * 
	 * @param name
	 *            汉字
	 * @return 拼音
	 */
	private static String HanyuToPinyin(String name) {
		char[] nameChar = name.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return pinyinName;
	}

	public static void main(String[] args) {
		System.out.println(HanyuToPinyin("赵飞"));
	}
}
