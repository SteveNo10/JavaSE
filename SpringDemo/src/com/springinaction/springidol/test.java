package com.springinaction.springidol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String args[]){
		try{
			@SuppressWarnings("resource")
			ApplicationContext obj = new ClassPathXmlApplicationContext("com/springinaction/springidol/spring-idol.xml");
			Juggler juggler = (Juggler)obj.getBean("duke");
			juggler.perform();
			
			PoeticJuggler poeticJuggler = (PoeticJuggler)obj.getBean("poeticDuke");
			poeticJuggler.perform();
	
			Stage stage = (Stage)obj.getBean("theStage");
			stage.Say();
			
			Ticket ticket1 = (Ticket)obj.getBean("ticket");
			ticket1.PrintTicket();
			Ticket ticket2 = (Ticket)obj.getBean("ticket");
			ticket2.PrintTicket();
			Ticket ticket3 = (Ticket)obj.getBean("ticket");
			ticket3.PrintTicket();
			
			@SuppressWarnings("unused")
			Auditorium auditorium = (Auditorium)obj.getBean("auditorium");
			
			Instrumentalist kenny = (Instrumentalist)obj.getBean("kenny");
			kenny.perform();
			
			Instrumentalist john = (Instrumentalist)obj.getBean("john");
			john.perform();
			
			Instrumentalist jj = (Instrumentalist)obj.getBean("jj");
			jj.perform();
			
			OnManBand bank = (OnManBand)obj.getBean("bank");
			bank.perform();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
