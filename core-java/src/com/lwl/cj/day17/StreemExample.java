package com.lwl.cj.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class Product {
	
		String name;
		double price;
		public Product(String name, double price) {
			super();
			this.name = name;
			this.price = price;
		}
		@Override
		public String toString() {
			return "Product [name=" + name + ", price=" + price + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		
		
}

class DescPrice implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return Double.valueOf(o2.price).compareTo(Double.valueOf(o1.price));
	}
	
}

class DescName implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return Double.valueOf(o2.price).compareTo(Double.valueOf(o1.price));
	}
	
}

public class StreemExample {

	
		public static void main(String[] args) {
			
					List<Product> plist = new ArrayList<>();	
					plist.add(new Product("Lenovo", 35000));
					plist.add(new Product("Lenovo", 45000));
					plist.add(new Product("Sony", 35000));
					plist.add(new Product("Dell", 65000));
					
					
					Collections.sort(plist,new DescPrice());
					
					//plist.sort((p1,p2)->p1.getName().compareTo(p2.getName()));
					plist.sort(Comparator.comparing(Product::getPrice));
					
					System.out.println(plist);
			
			
					List<Integer> list = new ArrayList<>();
					
					list.add(1);
					list.add(3);
					list.add(5);
					list.add(4);
					list.add(6);
					list.add(9);
					list.add(2);
					
					Collections.sort(list);
					
					// Get the number which are divisible by 2 but not with 4
					
					List<Integer> flist = new ArrayList<Integer>();
					for(Integer ele:list) {
						if(ele % 2 == 0 && ele % 4 != 0) {
							flist.add(ele);
						}
					}
					System.out.println(flist);
					
					flist = list.stream()
							     .filter(ele->ele % 2 == 0 && ele % 4 != 0)
							     .collect(Collectors.toList());
					
					List<Integer> dlist = new ArrayList<Integer>();
					for(Integer ele:list) {
							ele *= ele;
							dlist.add(ele);
						
					}
					dlist = list.stream()
							    .map(e->e*e)
							    .collect(Collectors.toList());
					
					System.out.println(dlist);
					
					
					List<String> namesList = new ArrayList<String>();
					namesList.add("Charan");
					namesList.add("Dhatri");
					namesList.add("Tanvi");
					namesList.add("Aadhaya");
					namesList.add("Ramesh");
					
					List<Integer> llist = namesList.stream().map(e->e.length()).collect(Collectors.toList());
					
					// Get length of all names, name starts with A and length should be more 5 characters
					
					namesList.stream().filter(e->e.startsWith("A"))
					                  .map(e->e.length())
					                  .filter(e->e>=5)
									  .collect(Collectors.toList());
					
//					System.out.println(namesList);
//					Collections.sort(namesList);
//					System.out.println(namesList);
					
					namesList.sort(Comparator.naturalOrder());
					
					System.out.println(namesList);
					
										
					
		}
}
