package com.test;

public class Demo {
	
	private String name;
	private int age;
	
	public Demo (){
		
	}
	public Demo (String a, int b){
		this.name = a;
		this.age = b;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "[" + this.name + " " + this.age + "]";
	}
}
