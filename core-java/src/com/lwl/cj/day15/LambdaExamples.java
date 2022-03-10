package com.lwl.cj.day15;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@FunctionalInterface
interface MathService {
	public int perform(int a, int b);
	default boolean isEven(int a) {
		return a % 2 == 0;
	}
	public static void showDate() {
		System.out.println(LocalDateTime.now());
	}
	
}

interface MyPredicate{
	public boolean test(int ele);
		
}

class ResultService {
	public void showResult(MathService mathService, int a, int b) {
		System.out.println(mathService.perform(a, b));
	}
	
	public List<Integer> filterData(List<Integer> list,MyPredicate obj) {
		List<Integer> flist =new ArrayList<Integer>();
		for(Integer ele:list) {
			if(obj.test(ele)) {
				flist.add(ele);
			}
		}
		
		return flist;
	}
}

class Even implements MyPredicate{

	@Override
	public boolean test(int ele) {
		
		return ele % 2 == 0;
	}
	
}
class Odd implements MyPredicate{

	@Override
	public boolean test(int ele) {
		
		return ele % 2 != 0;
	}
	
}
class EvenAndNotDivisibleBy4 implements MyPredicate{

	@Override
	public boolean test(int ele) {
		
		return ele % 2 == 0 && ele %4 != 0;
	}
	
}

public class LambdaExamples {

	public static void main(String[] args) {
		ResultService obj = new ResultService();
		obj.showResult((a,b) -> a + b, 10, 20);
		obj.showResult((a,b) -> a * b, 10, 20);
		
		List<Integer> list =new ArrayList<Integer>();
		for(int i=1;i<=10;i++) {
			int val = ThreadLocalRandom.current().nextInt(100,999);
			list.add(val);
		}
		System.out.println(list);
		System.out.println(obj.filterData(list,(num)->num % 2==0));
		System.out.println(obj.filterData(list,(num)->num %2 != 0));
		System.out.println(obj.filterData(list,(ele)-> ele % 2 == 0 && ele %4 != 0));
		// Even
		// Odd
		// Number Even but not divisible by 4
		
	}
}
