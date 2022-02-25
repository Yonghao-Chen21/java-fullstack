package com.lwl.cj.day6;

public class ArraySearchMultipleElements {

	public static void main(String[] args) {

	}

	public int[] maxElementInEachRow(int[][] arr) {
		
		return null;
	}
	public void rotateArray(int[] arr,int n) {
		
	}
	
	public boolean search(int[] arr, int e1, int e2, int e3) {

		if (searchElement(arr, e1) && searchElement(arr, e2) && searchElement(arr, e3)) {
			return true;
		}
		return false;
	}

	public static boolean searchElement(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return true;
			}
		}
		return false;
	}
}
