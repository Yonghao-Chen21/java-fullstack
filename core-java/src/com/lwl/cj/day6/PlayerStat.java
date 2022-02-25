package com.lwl.cj.day6;

public class PlayerStat {

	public static void main(String[] args) {

				
		String data = "ShubmanGill,Batsman,80000000.0,India,GT-SaiSudarshan,Batsman,2000000.0,India,GT-AbhinavSadarangani,Batsman,26000000.0,India,GT";
		String[] arr = data.split("-");
		
		Player[] players = new Player[arr.length];
		int i = 0;
		for(String ele:arr) {
			String[] d = ele.split(",");
			String name = d[0];
			String role = d[1];
			double amount = Double.parseDouble(d[2]);
			String country = d[3];
			String team = d[4];
			
			Player player = new Player(name, role, country, amount, team);
			players[i++] = player;
		}
		
		for(Player p:players) {
			System.out.println(p.name+" "+p.amount);
		}
		
		// Find average amount
		
		// Max amount min amount
		
		double max = players[0].amount;
		double min = players[0].amount;
		for(int l=1;l<players.length;l++) {
			if(max < players[i].amount) {
				max = players[i].amount;
			}
			if(min > players[i].amount) {
				min = players[i].amount;
			}
		}
		
		System.out.println("Max amount :"+max);
		
		

	}
}
