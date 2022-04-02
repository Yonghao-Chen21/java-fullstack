package com.careerit.sl.core.di.javaconfig;

public abstract class Game {

		public void start() {
			System.out.println(this.getClass().getSimpleName()+" is going to start");
		}
		public abstract void play();
		public void stop() {
			System.out.println(this.getClass().getSimpleName()+" is going to stop");
		}
}
