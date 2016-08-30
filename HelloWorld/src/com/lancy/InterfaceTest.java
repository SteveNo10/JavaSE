package com.lancy;

interface Animal{
	void Eat();
	void Breath();
	void Move();
}

interface Mammal extends Animal{
	void DrunkMilk();
}

class Human implements Mammal{
	public void Eat(){
		System.out.println("Human Eat");
	}
	
	public void Breath(){
		System.out.println("Human Breath");
	}
	
	public void Move(){
		System.out.println("Human Move");
	}
	
	public void DrunkMilk(){
		System.out.println("Human DrunkMilk");
	}
}

public class InterfaceTest {
	
}
