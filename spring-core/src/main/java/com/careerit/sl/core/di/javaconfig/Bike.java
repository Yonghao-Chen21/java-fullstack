package com.careerit.sl.core.di.javaconfig;

public class Bike extends Game{

	@Override
	public void play() {
		System.out.println("You are playing "+this.getClass().getSimpleName()+" game, Please wear helmet....");
	}

}
