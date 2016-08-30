package com.spring.show;

public class Stage {
	private Stage() {
		
	}
	
	private static class StageSingle {
		private static Stage instance = new Stage();
	}
	
	public static Stage getInstance() {
		return StageSingle.instance;
	}
	
	public void Prepare() {
		System.out.println("The huge stage is prepared!");
	}
}
