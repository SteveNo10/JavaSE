package com.lancy.qq;

class Ticket{
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public void releaseNum(){
		this.num--;
	}
	
	Ticket(int _num){
		setNum(_num);
	}
}

class Saler extends Thread{
	private Ticket ticket;
	private String threadName;
	
	public void run(){
		while(true){
			synchronized(ticket){
				if(ticket.getNum() > 0){
					System.out.println(threadName + " sales: " + ticket.getNum());
					ticket.releaseNum();
				}
				else{
					break;
				}
			}
		}
	}
	
	Saler(Ticket _ticket, String _threadName){
		super(_threadName);
		this.ticket = _ticket;
		this.threadName = _threadName;
	}
}

public class MySynchronize {
	public static void main(String args[]){
		Ticket ticket = new Ticket(1000);
		Saler s1 = new Saler(ticket, "Saler1");
		Saler s2 = new Saler(ticket, "Saler2");
		s1.start();
		s2.start();
	}
}
