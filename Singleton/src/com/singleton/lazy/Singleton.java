package com.singleton.lazy;

public class Singleton {
	private static Singleton singleton = null;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	
	public void Print() {
		System.out.println("This is a lazy singleton");
	}
}
