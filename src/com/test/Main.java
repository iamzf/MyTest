package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
	public static Demo demo;
	public static Class<?> demo1;
	
	public static void main (String args[]) {
		try {
			demo1 = Class.forName("com.test.Demo");
			demo = (Demo) demo1.newInstance();
			
			Constructor<?>[] constructor = demo1.getConstructors();
			for (Constructor<?> constructor2 : constructor) {
				System.out.println(constructor2);
			}
			
			demo.setName("test");
			demo.setAge(23);
			System.out.println(demo.toString());
			
			Method method = demo1.getMethod("setName", String.class);
			method.invoke(demo, "zhaofei");
			System.out.println(demo.getName());
			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
