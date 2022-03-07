package com.lwl.cj.day9;
import static com.lwl.cj.day9.AccountUtil.maskAccountNumber;

import java.time.LocalDate;

public class Account {

		private String accNumber;
		private String name;
		private double balance;
		
		public  Account(String name,double balance) {
			 this.accNumber = AccountUtil.newAccountNumber();
			 this.name = name;
			 this.balance = balance;
		}
		
		public void withdraw(double amount){
			if(amount <= balance) {
				balance -= amount;
				System.out.println("Dear "+name+", Accnumber :"+maskAccountNumber(accNumber)+" has "+balance+" "+LocalDate.now());
			}else {
				System.out.println("Sorry! you don't enough funds");
			}
			
		}
		public void showInfo(){
			System.out.println("Acc     :"+accNumber);
			System.out.println("Name    :"+name);
			System.out.println("Balance :"+balance);
		}
		public void deposit(double amount){
			balance += amount;
			System.out.println("Dear "+name+", Accnumber :"+maskAccountNumber(accNumber)+" has "+balance+" "+LocalDate.now());
		}

		public String getAccNumber() {
			return accNumber;
		}

		public String getName() {
			return name;
		}

		public double getBalance() {
			return balance;
		}

		

		
		
		
		
}
