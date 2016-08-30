package com.ifnoelse.servlet;

public class JavaBean {
	private int count = 0;

	public int getCount() {
		return ++count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
