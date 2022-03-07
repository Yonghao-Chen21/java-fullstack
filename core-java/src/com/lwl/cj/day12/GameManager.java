package com.lwl.cj.day12;

abstract class Game {

	public void start() {
		System.out.println(this.getClass().getSimpleName() + " is going start");
	}

	public abstract void play();

	public void stop() {
		System.out.println(this.getClass().getSimpleName() + " is going stop");
	}
}

class Bike extends Game {

	@Override
	public void play() {
		System.out.println("You playing Bike game, please wear helmet............");
	}

}

abstract class One {
	abstract void m1();

	abstract void m2();

	abstract void m3();
}

abstract class Two extends One {
	@Override
	void m1() {

	}

}

class Three extends Two {
	@Override
	void m2() {
		// TODO Auto-generated method stub

	}

	@Override
	void m3() {
		// TODO Auto-generated method stub

	}
}

abstract class Four {

	public void m4() {

	}
}

public class GameManager {

	public static void main(String[] args) {

		Game game = new Bike();
		game.play();

	}
}
