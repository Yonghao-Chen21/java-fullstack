package com.lwl.cj.day6;

public class Player {

	String name;
	String role;
	double price;
	String country;
	String team;

	public Player(String name, String role, double price, String country, String team) {
		super();
		this.name = name;
		this.role = role;
		this.country = country;
		this.price = price;
		this.team = team;
	}

	public String getattribute(String attribute) {
		switch (attribute) {
		case "Player":
			return name;
		case "Role":
			return role;
		case "Country":
			return country;
		case "Team":
			return team;
		}
		return attribute;

	}

	public void show() {
		System.out.println(name + " " + role + " " + price + " " + country + " " + team);
	}
}
