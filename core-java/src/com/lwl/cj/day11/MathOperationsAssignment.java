package com.lwl.cj.day11;

import java.util.Arrays;

public class MathOperationsAssignment {
	
	public static void main(String[] args) {
		MathOperationsAssignment obj = new MathOperationsAssignment();
		System.out.println(obj.add(1,2,3,4,5));
		System.out.println(Arrays.toString(obj.generatePrime(5)));
		System.out.println(Arrays.toString(obj.generatePrime(2,10)));
		System.out.println(obj.search(new String[] {"AA","BB","CC"},"AA","BB","CC","DD"));
	}
	
	public int add(int a,int b) {
		return a + b;
	}
	
	public int add(int... arr) {
		int rs = 0;
		for(int i : arr) {
			rs += i;
		}
		return rs;
	}

	public boolean isPrime(int n) {
		boolean flag = true;
		for(int i = 2;i<=n/2;i++) {
			if(n%i==0) {
				flag = false;
				break;
			}				
		}
		return flag;
	}
	
	public int[] generatePrime(int n) {
		int[] rs = new int[n];
		int count = 0;
		int candidate = 2;
		while(count<n) {
			if(isPrime(candidate)){
				rs[count] = candidate;
				count++;
			}
			candidate++;
		}
		return rs;
	}
	
	public int[] generatePrime(int lb, int ub) {
		int[] tmp = new int[ub-lb+1];
		int count = 0;
		for(int i = lb;i <= ub; i++) {
			if(isPrime(i)) {
				tmp[count] = i;
				count++;
			}
		}
		int [] rs = new int[count];
		System.arraycopy(tmp,0,rs,0,count);
		return rs;
	}
	
	public boolean search(String[] arr, String key) {
		for(String str : arr) {
			if(str.equals(key)) {
				return true;
			}
		}
		return false;
	}
	public boolean search(String[] arr, String key1, String key2) {
		if (search(arr,key1)&&search(arr,key2)) {
			return true;
		}
		return false;
	}
	public boolean search(String[] arr,String... args) {
		for (String str : args) {
			if(! search(arr,str)) {
				return false;
			}
		}
		return true;
	}
}

