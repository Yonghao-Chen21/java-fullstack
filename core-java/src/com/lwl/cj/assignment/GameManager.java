package com.lwl.cj.assignment;

import java.util.concurrent.ThreadLocalRandom;

interface Game {

	public void start();

	public void play();

	public void stop();

}

abstract class AbstractGame implements Game {

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}

class Bike extends AbstractGame implements Game {

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

}

class Boat extends AbstractGame implements Game {

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

}

class Car extends AbstractGame implements Game {

	@Override
	public void play() {
		// TODO Auto-generated method stub

	}

}

public class GameManager {

	// Generate 10 random games and store it in array. Print the count of each game
	public static void main(String[] args) {
		Game[] games = new Game[10];
		int[] rs = { 0, 0, 0 };
		String[] names = {"Bike","Boat","Car"};
		for (int i = 0; i < 10; i++) {
			switch (ThreadLocalRandom.current().nextInt(1, 4)) {
			case 1:
				games[i] = new Bike();
				break;
			case 2:
				games[i] = new Boat();
				break;
			case 3:
				games[i] = new Car();
			}

		}
		for (Game game : games) {
			if (game instanceof Bike) {
				rs[0] += 1;
			} else if (game instanceof Boat) {
				rs[1] += 1;
			} else if (game instanceof Car) {
				rs[2] += 1;
			}
		}
		for (int i = 0; i < 3; i ++) {
			System.out.println(String.format("%s game count: %s.",names[i],rs[i]));
		}

	}

}