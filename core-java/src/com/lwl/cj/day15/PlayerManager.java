package com.lwl.cj.day15;

public class PlayerManager {

		public static void main(String[] args) {
			
				PlayerService pservice = new PlayerServiceImpl();
				
				int count = pservice.playerCount((p)->p.getRole().equals("Bowler") && p.getPrice()==2000000);
				System.out.println(count);
		}
}
