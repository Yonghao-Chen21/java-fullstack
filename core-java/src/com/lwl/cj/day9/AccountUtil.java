package com.lwl.cj.day9;

public final class AccountUtil {
	
		private static Long accNumber = 1000000001L;
	
		private AccountUtil() {			
		}
		
		public static String maskAccountNumber(String accNumber){
			return "*******"+accNumber.substring(accNumber.length()-3,accNumber.length());
		}
		
		public static String newAccountNumber() {
			return "SB-"+accNumber++;
		}

}
