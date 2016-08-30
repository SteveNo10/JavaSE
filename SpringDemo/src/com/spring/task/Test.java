package com.spring.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/spring/task/task.xml");
		//TaskJob taskJob = (TaskJob)ac.getBean("taskJob");
		//taskJob.job1();
		//Thread.sleep(10000);
	}

}
