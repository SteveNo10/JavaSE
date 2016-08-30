package com.lancy.qq;

class Producter{
	public static final int ProductNum = 10;
	private int[] producters;
	private int productIndex;
	private int customIndex;
	private int producter;
	
	Producter(){
		producters = new int[ProductNum];
		productIndex = 0;
		customIndex = 0;
		producter = 0;
	}
	
	public synchronized void GetProducter(){
		if(customIndex == productIndex){
			try{
				System.out.println("Custom wait...");
				wait();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		int cusProduct = producters[customIndex];
		System.out.println("Custom on " + customIndex + ":" + cusProduct);
		
		int nextCustom = customIndex + 1;
		if(nextCustom == ProductNum){
			nextCustom = 0;
		}
		customIndex = nextCustom;
		
		notify();
	}
	
	public synchronized void SetProducter(){
		int nextProduct = productIndex + 1;
		if(nextProduct == ProductNum){
			nextProduct = 0;
		}
		
		if(nextProduct == customIndex){
			try{
				System.out.println("Product wait...");
				wait();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		int newProduct = producter++;
		producters[productIndex] = newProduct;
		System.out.println("Product on " + productIndex + ":" + newProduct);
		productIndex = nextProduct;
		
		notify();
	}
}

class Product extends Thread{
	private Producter producter;
	
	Product(Producter _producter){
		this.producter = _producter;
	}
	
	public void run(){
		while(true){
			producter.SetProducter();
		}
	}
}

class Custom extends Thread{
	private Producter producter;
	
	Custom(Producter _producter){
		this.producter = _producter;
	}
	
	public void run(){
		while(true){
			producter.GetProducter();
		}
	}
}

public class PruductCustom {
	public static void main(String args[]){
		Producter producter = new Producter();
		Product product = new Product(producter);
		Custom custom = new Custom(producter);
		
		product.start();
		custom.start();
	}
}
