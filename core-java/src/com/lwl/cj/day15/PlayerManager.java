package com.lwl.cj.day15;

public class PlayerManager {

	public static void main(String[] args) {

		PlayerService pservice = new PlayerServiceImpl();
		// the expression define the test method. lambda expression is instantiation of
		// anonymous instance
		int count = pservice.playerCount((p) -> p.getRole().equals("Bowler") && p.getPrice() == 2000000);
		System.out.println(count);
		// Find count of players for the given team
		int count2 = pservice.playerCount(p -> p.getTeam().equals("RCB"));
		System.out.println(count2);
		// Find count of players for the given team and role
		int count3 = pservice.playerCount(p -> p.getTeam().equals("RCB") && p.getRole().equals("Bowler"));
		System.out.println(count3);
		// Find sum of amount by the role
		double sum = pservice.totalAmount(p -> p.getRole().equals("Bowler"));
		System.out.println(sum);
		// Find sum of amount for the given team
		double sum1 = pservice.totalAmount(p -> p.getTeam().equals("RCB"));
		System.out.println(sum1);
		// Find sum of amount for the given role and team
		double sum2 = pservice.totalAmount(p -> p.getRole().equals("Bowler") && p.getTeam().equals("RCB"));
		System.out.println(sum2);

	}
}
