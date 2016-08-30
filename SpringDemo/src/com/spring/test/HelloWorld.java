package com.spring.test;

public class HelloWorld {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void PringMsg(){
		System.out.println("Your msg : " + msg);
	}
}
