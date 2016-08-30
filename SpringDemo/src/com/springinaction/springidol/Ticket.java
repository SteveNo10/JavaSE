package com.springinaction.springidol;

public class Ticket {
	public static int NEXTTICKETNUM = 0;
	private int ticketnum;
	public Ticket() {
		ticketnum = NEXTTICKETNUM++;
	}
	
	public void PrintTicket() {
		System.out.println("Ticket no" + this.ticketnum);
	}
}
