package com.careerit.ipl;

public class Player {
	private String name;
	private String role;
	private double price;
	private String country;
	private String team;
	public Player(String name, String role, double price, String country, String team) {
		super();
		this.name = name;
		this.role = role;
		this.price = price;
		this.country = country;
		this.team = team;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}

	
	
}
