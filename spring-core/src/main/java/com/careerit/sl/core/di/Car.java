package com.careerit.sl.core.di;

import org.springframework.stereotype.Component;

@Component("car")
public class Car extends Game {

	@Override
	public void play() {
		System.out.println("You are playing "+this.getClass().getSimpleName()+" game, Please wear seat belt....");
	}

}
