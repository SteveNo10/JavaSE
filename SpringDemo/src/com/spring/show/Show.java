package com.spring.show;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Show {
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		@SuppressWarnings("resource")
		ApplicationContext obj = new ClassPathXmlApplicationContext("com/spring/show/show.xml");
		Stage stage = (Stage)obj.getBean("stage");
		stage.Prepare();
		
		for(int i=0; i<10; ++i) {
			Ticket ticket = (Ticket)obj.getBean("ticket");
			ticket.PrintTicket();
		}
		
		Light light = (Light)obj.getBean("light");
		//light.TurnOn();
		//light.TurnOff();
		
		Singer jay = (Singer)obj.getBean("zhoujielun");
		jay.Sing();
		
		Singer jj = (Singer)obj.getBean("linjunjie");
		jj.Sing();
		
		
		Singer jolin = (Singer)obj.getBean("caiyilin");
		jolin.Sing();
		
		Band beyond = (Band)obj.getBean("beyond");
		beyond.Show();
	}
}
