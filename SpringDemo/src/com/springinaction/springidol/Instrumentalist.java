package com.springinaction.springidol;

public class Instrumentalist implements Performer {

	@Override
	public void perform() throws PerformanceException {
		System.out.println("Playing..." + song + " : ");
		instrument.play();
	}
	
	private String song;
	
	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	private Instrument instrument;
}
