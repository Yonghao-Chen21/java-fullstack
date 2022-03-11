package com.lwl.cj.day15;

import java.util.List;
import java.util.function.Predicate;

public class PlayerServiceImpl implements PlayerService {

	private List<Player> list;

	public PlayerServiceImpl() {
		list = CsvReaderUtil.getPlayers();
	}

	@Override
	public int playerCount(Predicate<Player> predicate) {
		int count = 0;
		for (Player player : list) {
			if (predicate.test(player)) {
				count++;
			}
		}
		return count;
	}

	@Override
	public double totalAmount(Predicate<Player> predicate) {
		// TODO Auto-generated method stub
		double sum = 0;
		for (Player player : list) {
			if (predicate.test(player)) {
				sum += player.getPrice();
			}
		}
		return sum;
	}

}
