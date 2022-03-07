package com.lwl.cj.day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StockManager {

	public static void main(String[] args) {

		// CSV
		StockManager obj = new StockManager();
		Stock[] stocks = obj.loadStocks();
		double cumReturn = 0;
		for (Stock stock : stocks) {
			if (stock.getCode().equals("AAA")) {
				cumReturn += stock.getActReturn();
			}

		}
		System.out.println("Cumulative Returns of AAA is: " + cumReturn);

		// Find cumulative returns of the given stock
	}

	private Stock[] loadStocks() {
		Stock[] arr = null;
		try {
			List<String> list = Files.readAllLines(Paths.get("data.csv"));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			arr = new Stock[list.size() - 1];
			for (int i = 1; i < list.size(); i++) {
				String[] data = list.get(i).split(",");
				LocalDate date = LocalDate.parse(data[0],formatter);
				String code = data[1];
				double price = Double.parseDouble(data[2]);
				double actReturn = Double.parseDouble(data[3]);
				arr[i - 1] = new Stock(date, code, price, actReturn);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
