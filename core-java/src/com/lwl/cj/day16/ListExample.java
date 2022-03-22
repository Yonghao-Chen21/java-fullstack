package com.lwl.cj.day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListExample {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<>();

		list1.add(101);
		list1.add(103);
		list1.add(104);
		list1.add(102);

		List<Integer> list2 = new ArrayList<>();

		list2.add(105);
		list2.add(106);
		list2.add(107);
		list2.add(109);
		list1.addAll(list2);

		// Get all the even numbers from the list

		List<Integer> evenList = new ArrayList<Integer>();

		for (Integer ele : list1) {
			if (ele % 2 == 0) {
				evenList.add(ele);
			}
		}

		List<Integer> oddList = list1.stream().filter(ele -> ele % 2 != 0).collect(Collectors.toList());

		System.out.println(list1);
		System.out.println(evenList);
		System.out.println(oddList);
		// you don't actually need the name x in order to invoke println for each of the
		// elements.
		list1.stream().forEach(System.out::println);
		System.out.println("-----------------------------------------");

		Iterator<Integer> itr = list1.iterator();
		while (itr.hasNext()) {
			Integer ele = itr.next();
			System.out.println(ele);
			if (ele > 105) {
				itr.remove();
			}
		}
		System.out.println("-----------------------------------------");
		// transfer a list to a list iterator
		ListIterator<Integer> listItr = list1.listIterator();
		while (listItr.hasNext()) {
			Integer ele = listItr.next();
			System.out.println(ele);

		}
		System.out.println("-----------------------------------------");
		while (listItr.hasPrevious()) {
			Integer ele = listItr.previous();
			if (ele == 105) {
				listItr.set(108);

			}
			System.out.println(ele);
		}

		System.out.println(list1);

		List<Integer> blist = IntStream.range(10, 30).boxed().collect(Collectors.toList());
		List<Integer> glist = IntStream.of(5, 15, 10, 20, 30, 1, 2, 3, 4, 5, 6, 7, 8, 9).boxed()
				.collect(Collectors.toList());

		for (Integer ele : glist) {
			if (!blist.contains(ele)) {
				blist.add(ele);
			}
		}
		System.out.println(blist);
		Collections.sort(blist);
		System.out.println(blist);

	}
}
