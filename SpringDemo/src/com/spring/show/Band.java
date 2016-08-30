package com.spring.show;
import java.util.Collection;

public class Band {
	private Collection<Singer> singers;

	public Collection<Singer> getSingers() {
		return singers;
	}

	public void setSingers(Collection<Singer> singers) {
		this.singers = singers;
	}
	
	public void Show() {
		for(Singer singer : singers) {
			singer.Sing();
		}
	}
}
