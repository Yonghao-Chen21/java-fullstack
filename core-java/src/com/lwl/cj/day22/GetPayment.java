package com.lwl.cj.day22;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetPayment {

	public static List<WorkRecord> list = getRecords();

	public static List<WorkRecord> getRecords() {
		List<String> list = null;
		try {
			list = Files.readAllLines(Paths.get("emp_data.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		DateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		List<WorkRecord> rlist = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			String[] data = list.get(i).split(",");
			Date date = null;
			try {
				date = (Date) formatter.parse(data[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String name = data[1];
			double price = Double.parseDouble(data[2]);
			int hour = 0;
			Date startTime = null;
			try {
				startTime = (Date) formatter2.parse(data[3]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date endTime = null;
			try {
				endTime = (Date) formatter2.parse(data[4]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hour = (int) (endTime.getTime() - startTime.getTime()) / (1000 * 60 * 60);
			rlist.add(new WorkRecord(date, name, price, hour, price * hour));
		}
		return rlist;
	}
	
	public Map<String,Double> getSum(){
		Map<String,Double> rs = new HashMap<>();
		for(WorkRecord ele:list) {
			String key = ele.getName();
			rs.putIfAbsent(key, (double) 0);
			rs.put(key, rs.get(key)+ele.getAmount());
			//rs.compute(key,(k,value)-> k == null ? value:rs.get(k)+value );

		}
		return rs;
	}
	
	public RecordSum getMaxSum(Map<String,Double> sumMap) {
		RecordSum rs = null;
		for(String name : sumMap.keySet()) {
			if(rs == null) {
				rs = new RecordSum(name,sumMap.get(name));
			}else {
				rs = (sumMap.get(name)>rs.getAmount())?new RecordSum(name,sumMap.get(name)):rs;
			}
			
		}
		
		return rs;
	}
	
	public static void main(String[] args) {
		GetPayment obj = new GetPayment();
		Map<String,Double> sums = obj.getSum();
		sums.entrySet().forEach(System.out::println);
		System.out.println(obj.getMaxSum(sums));
	}

}

class RecordSum{
	private String name;
	private double amount;
	public RecordSum(String name, double amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public double getAmount() {
		return amount;
	}
	@Override
	public String toString() {
		return "RecordSum [name=" + name + ", amount=" + amount + "]";
	}
	
}

class WorkRecord {
	private Date date;
	private String name;
	private double price;
	private int hour;
	private double amount;
	
	public WorkRecord(Date date, String name, double price, int hour, double amount) {
		super();
		this.date = date;
		this.name = name;
		this.price = price;
		this.hour = hour;
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getHour() {
		return hour;
	}
	public double getAmount() {
		return amount;
	}
	@Override
	public String toString() {
		return "WorkRecord [date=" + date + ", name=" + name + ", price=" + price + ", hour=" + hour + ", amount="
				+ amount + "]";
	}
	
}
