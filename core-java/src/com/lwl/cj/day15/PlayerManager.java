package com.lwl.cj.day15;

public class PlayerManager {

		public static void main(String[] args) {
			
				PlayerService pservice = new PlayerServiceImpl();
				
			
				int count = pservice.playerCount((p)->p.getRole().equals("Bowler") && p.getPrice()==2000000);
				
				
				 // Find count of players for the given team
			
				// Find count of players for the given team and role

				// Find sum of amount by the role
				
				// Find sum of amount for the  given team
				
				// Find sum of amount for the given role and team
				
				
				System.out.println(count);
		}
}
