package com.careerit.sl.core.di.javaconfig;

public class GameServiceImpl implements GameService {

	private Game game;

	public GameServiceImpl(Game game) {
		this.game = game;
	}

	@Override
	public void playGame() {
		game.start();
		game.play();
		game.stop();
	}

}
