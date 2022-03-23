package com.careerit.ymal;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import lombok.Data;

@Data
class Order{
	private String orderNo;
	private Date date;
	private String customerName;
	private List<OrderLine> orderLines;
}

@Data
class OrderLine {
	private String item;
	private int quantity;
	private double unitPrice;
}

public class OrderService {

	public static void main(String[] args) {
		
		YAMLFactory  yaml = new YAMLFactory();
		ObjectMapper mapper = new ObjectMapper(yaml);
		List<Order> orders = null;
		try {
			YAMLParser yamlParser = yaml.createParser(new File("src/main/resources/orders.yaml"));
			orders = mapper.readValues(yamlParser,new TypeReference<Order>() {}).readAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		orders.stream().forEach(System.out::println);
		for(Order o:orders) {
			List<OrderLine> lines = o.getOrderLines();
			double sum = 0;
			for (OrderLine line:lines) {
				sum+= line.getUnitPrice() * line.getQuantity();
			}
			System.out.println(sum);
		}
	}

}
