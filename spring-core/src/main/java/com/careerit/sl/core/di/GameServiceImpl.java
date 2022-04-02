package com.careerit.sl.core.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameServiceImpl implements GameService {

	private Game game;

	@Autowired
	public GameServiceImpl(@Qualifier("car") Game game) {
		this.game = game;
	}

	@Override
	public void playGame() {
		game.start();
		game.play();
		game.stop();
	}

}
