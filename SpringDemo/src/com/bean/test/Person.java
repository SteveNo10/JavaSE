package com.bean.test;

public class Person {
	private String name;
	private int age;
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
	
	public void Print(){
		System.out.println("My name is " + this.getName() + " and age is " + this.getAge());
	}
}
