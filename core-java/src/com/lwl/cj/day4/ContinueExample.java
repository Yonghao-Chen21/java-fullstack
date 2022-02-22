package com.lwl.cj.day4;

public class ContinueExample {

		public static void main(String[] args) {
			
				// don't print numbers which are divisible by 3 || 5
				for(int i=1;i<=10;i++) {
					if(i % 3 == 0 || i % 5 == 0) {
						continue;
					}
					System.out.print(i+" ");
				}
				System.out.println();
				for(int i=1;i<=3;i++) {
					for(int j=1;j<=3;j++) {
						if(i == j) {
							continue;
						}
						System.out.println(i+" "+j);
					}
				}
		}
}
