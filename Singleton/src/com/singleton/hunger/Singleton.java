package com.singleton.hunger;

public class Singleton {
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public void Print() {
		System.out.println("singleton");
	}
}
