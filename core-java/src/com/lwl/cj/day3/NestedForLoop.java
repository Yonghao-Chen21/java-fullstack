package com.lwl.cj.day3;

public class NestedForLoop {

		public static void main(String[] args) {
			showTables(17, 20);
		}
		
		public static void showTables(int lb,int ub) {
			
			for(int l=lb;l<=ub;l++) {
				int num = l;
				for(int i=1;i<=10;i++) {
					System.out.println(num+" * "+i+" = "+(num*i));
				}
				System.out.println("-----------------------");
			}
		}
		
		public static boolean isPrime(int num) {
			    boolean flag = true;
				if(num < 2) {
					return false;
				}
				if(num % 2 == 0 && num != 2) {
					return false;
				}
				for(int i=2;i<=num/2;i++) {
					if(num % i== 0) {
						flag = false;
						break;
					}
				}
				return flag;
			
				
		}
}
