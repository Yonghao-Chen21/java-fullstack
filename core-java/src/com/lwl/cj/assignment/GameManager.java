package com.lwl.cj.assignment;

interface Game{	
		public void start();
		public void play();
		public void stop();
		
}
abstract class AbstractGame implements Game{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	
}

class Bike extends AbstractGame implements Game{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

}
class Boat extends AbstractGame implements Game{

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
	
	
}
class Car extends AbstractGame implements Game{
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	
}

public class GameManager {

	
		// Generate 10 random games and store it in array. Print the count of each game
	
		
}
