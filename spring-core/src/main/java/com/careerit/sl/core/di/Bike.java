package com.careerit.sl.core.di;

import org.springframework.stereotype.Component;

@Component("bike")
public class Bike extends Game{

	@Override
	public void play() {
		System.out.println("You are playing "+this.getClass().getSimpleName()+" game, Please wear helmet....");
	}

}
