package com.ifnoelse.timertask;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskDemo {

	public void SimpleRun() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run() {
				System.out.println("schedule");
			}
		}, 1, 2000);
		
		timer.schedule(new TimerTask(){
			public void run() {
				System.out.println("111");
			}
		}, 0,2000);
	}
	
	public static void main(String[] args) {
		TimerTaskDemo timerTaskDemo = new TimerTaskDemo();
		timerTaskDemo.SimpleRun();
	}

}
