package com.spring.show;

public class Singer implements ISinger {
	
	public Singer(String name, String song, IInstrument instrument) {
		this.name = name;
		this.song = song;
		this.instrument = instrument;
	}
	
	public Singer() {
		
	}
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String song;
	private IInstrument instrument;
	
	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public IInstrument getInstrument() {
		return instrument;
	}

	public void setInstrument(IInstrument instrument) {
		this.instrument = instrument;
	}

	@Override
	public void Sing() {
		System.out.println(this.getName() + " sing " + this.getSong() + " and ");
		this.getInstrument().Play();
	}

}
