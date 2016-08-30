package learn.lang;

public class MemoryDemo {
	public static void main(String args[]){
		final int NUM = 1000;
		Runtime t = Runtime.getRuntime();
		long mem1;
		long mem2;
		Integer[] someIntger = new Integer[NUM];
		
		System.out.println("Total memory is : " + t.totalMemory());
		
		mem1 = t.freeMemory();
		System.out.println("Initial memory is : " + mem1);
		
		t.gc();
		mem1 = t.freeMemory();
		System.out.println("after t.gc() memory is : " + mem1);
		
		for(int i=0; i<NUM; ++i){
			someIntger[i] = new Integer(i);
		}
		mem2 = t.freeMemory();
		System.out.println("after new integer memory is : " + mem2);
		
		for(int i=0; i<NUM; ++i){
			someIntger[i] = null;
		}
		t.gc();
		mem2 = t.freeMemory();
		System.out.println("after collection memory is : " + mem2);
	}
}
