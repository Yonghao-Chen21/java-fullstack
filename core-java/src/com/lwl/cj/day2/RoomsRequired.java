package com.lwl.cj.day2;

import java.util.Scanner;

public class RoomsRequired {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the count:");
		int count = sc.nextInt();
		System.out.println("Enter the capacity: ");
		int capacity = sc.nextInt();

		int roomsCount = (count % capacity == 0) ? count / capacity : (count / capacity) + 1;

//		    if(count % capacity == 0) {
//		    	roomsCount = count / capacity;
//		    }else {
//		    	roomsCount = (count / capacity) + 1;
//		    }
		System.out.println(count + " capacity :" + capacity + " room count " + roomsCount);
		sc.close();
	}
}
