package com.lwl.cj.day8;

public class Account {

		static String bankName="LWL BANK";
		String name;
		String accountNumber;
		double balance;
		
		public Account(String name, String accountNumber, double balance) {
			this.name = name;
			this.accountNumber = accountNumber;
			this.balance = balance;
		}
		
		public void withDraw(double amount) {
			if(amount > balance) {
				System.out.println("Sorry you don't have enough funds to withdraw, your balance is "+balance);
				return;
			}
			balance = balance - amount;
			System.out.println("You have balance :"+balance);
		}
		public void deposit(double amount) {
			balance = balance + amount;
			System.out.println("You have balance :"+balance);
		}

		@Override
		public String toString() {
			return "Account [name=" + name + ", accountNumber=" + accountNumber + ", balance=" + balance + "]";
		}
		
		
		
		
}
