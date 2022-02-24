package com.lwl.cj.day5;

public class ArrayExamples {

		public static void main(String[] args) {
			double[] arr = new double[] {8,20,26,20,30,	24,19 };

			double max = arr[0];
			for(int i=1;i<arr.length;i++) {
				if(max < arr[i])
					max = arr[i];
			}
			System.out.println(max);
			
			
		}
}
