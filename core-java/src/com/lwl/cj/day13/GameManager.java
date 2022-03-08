package com.lwl.cj.day13;

abstract class Game {

	public abstract void play();
}

class Car extends Game {
	@Override
	public void play() {
	}
}

class Bike extends Game {
	@Override
	public void play() {
	}

	public void fly() {

	}
}

class Boat extends Game {
	@Override
	public void play() {

	}
}

public class GameManager {

	public static void main(String[] args) {

		System.out.println("------------1.Car 2.Bike 3.Boat----------");
		int ch = 3;

		Game ref = getUserChoiceGame(ch);
		// When user selected bike game ensure fly method is called
		if (ref instanceof Bike) {
			Bike game = (Bike) ref;
			game.play();
			game.fly();
		}else {
			ref.play();
		}
		

	}

	private static Game getUserChoiceGame(int ch) {

		if (ch == 1) {
			return new Car();
		} else if (ch == 2) {
			return new Bike();
		} else if (ch == 3) {
			return new Boat();
		}
		throw new IllegalArgumentException("Please enter only 1-3");
	}

}
