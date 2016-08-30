package com.spring.show;

public class Ticket {
	private static int ticketno = 1;
	private int ticket;
	public Ticket() {
		this.ticket = ticketno++;
	}
	
	public void PrintTicket() {
		System.out.println("Ticket no: " + this.ticket);
	}
}
