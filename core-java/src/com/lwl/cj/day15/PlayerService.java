package com.lwl.cj.day15;

import java.util.function.Predicate;

public interface PlayerService {

			public int playerCount(Predicate<Player> predicate);
			public double totalAmount(Predicate<Player> predicate);
}
