package com.springinaction.springidol;

public class Sonnet29 implements Poem {

	private static String[] LINES = {
			"This is one!",
			"This is two!",
			"This is three",
			"This is four",
			"This is five",
			"This is six",
			"This is seven",
			"This is eight",
			"This is night",
			"This is ten"
	};
	
	public Sonnet29() {
		
	}
	
	@Override
	public void recite() {
		for(String line : LINES) {
			System.out.println(line);
		}
	}

}
