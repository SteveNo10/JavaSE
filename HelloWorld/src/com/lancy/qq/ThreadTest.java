package com.lancy.qq;

class MyThread extends Thread{
	public void run(){
		for(int i=0; i<1000; ++i){
			System.out.println(i);
		}
	}
}

class MyRunnable implements Runnable{
	public void run(){
		for(int i=0; i<1000; ++i){
			System.out.println(i);
		}
	}
}

public class ThreadTest {
	public static void main(String args[]){
		Runnable r1 = new MyRunnable();
		Runnable r2 = new MyRunnable();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
