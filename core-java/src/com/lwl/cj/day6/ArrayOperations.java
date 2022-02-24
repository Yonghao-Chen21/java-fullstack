package com.lwl.cj.day6;

public class ArrayOperations {

	public static void main(String[] args) {
		
	}
	
	
	public static int[] sumOfEachRow(int[][] arr) {
		int[] temp = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			int s = 0;
			for(int j=0;j<arr[i].length;j++) {
				s = s + arr[i][j];
			}
			temp[i] = s;
		}
		return temp;
	}
	
	public static int sumOfElements(int[][] arr) {
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				sum = sum + arr[i][j];
			}
		}
		return sum;
	}
	
	public static boolean subSet(int[] arr,int[] sub) {
		for(int i=0;i<sub.length;i++) {
			if(!serchElement(arr, sub[i])) {
				return false;
			}
		}
		return true;
	}

	public static int occuranceOfKey(int[] arr, int key) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				count++;
			}
		}
		return count;
	}

	public static boolean serchElement(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return true;
			}
		}
		return false;
	}
}
