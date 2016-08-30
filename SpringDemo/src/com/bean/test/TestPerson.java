package com.bean.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPerson {
	public static void main(String args[]){
		@SuppressWarnings("resource")
		ApplicationContext obj = new ClassPathXmlApplicationContext("bean.xml");
		Person p = (Person)obj.getBean("person");
		p.Print();
	}
}
