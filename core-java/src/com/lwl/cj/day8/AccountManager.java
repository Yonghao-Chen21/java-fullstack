package com.lwl.cj.day8;

public class AccountManager {

		public static void main(String[] args) {
			
					System.out.println(Account.bankName);
					Account acc1 = new Account("Krish", "567890123", 35000);
					acc1.deposit(15000);
					System.out.println(acc1);
		}
}
