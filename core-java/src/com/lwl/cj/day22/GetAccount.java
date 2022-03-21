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
import java.util.stream.Collectors;

public class GetAccount {
	public static List<Return> list = getReturn();
	
	public static List<Return> getReturn(){
		List <String> list = null;
		try {
			list = Files.readAllLines(Paths.get("account.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		List<Return> rlist = new ArrayList<>();
		for (int i = 1;i<list.size();i++) {
			String[] data = list.get(i).split(",");
			Date date = null;
			try {
				date = (Date) formatter.parse(data[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Account account = Account.valueOf(data[1].replace("-","_"));
			Region region = Region.valueOf(data[2]);
			double ret_value = Double.parseDouble(data[3]);
			rlist.add(new Return(date,account,region,ret_value));
		}
		return rlist;
	}
	
	public List<Return> getReturnByRegion(Region region){
		return list.stream().filter(ele->ele.getRegion().equals(region)).collect(Collectors.toList());
	}
	
	public Map<Account,Double> getSum(List<Return> list){
		Map<Account,Double> rs = new HashMap<>();
		for(Return ele:list) {
			Account key = ele.getAccount();
			rs.putIfAbsent(key, (double) 0);
			rs.put(key, rs.get(key)+ele.getRet_value());
		}
		return rs;
	}
	
	public ReturnSum getMaxSum(Map<Account,Double> sumMap) {
		ReturnSum rs = new ReturnSum(Account.SB_1001,sumMap.get(Account.SB_1001));
		for (Account ele : Account.values()) {
			rs = (sumMap.get(ele)>rs.getRet_value())?new ReturnSum(ele,sumMap.get(ele)):rs;
		}
		return rs;
	}
	
	public static void main(String[] args) {
		GetAccount obj = new GetAccount();
		List<Return> naList =  obj.getReturnByRegion(Region.NA);
		Map<Account,Double> naSum = obj.getSum(naList);
		System.out.println("Sum of NA");
		naSum.entrySet().forEach(System.out::println);
		System.out.println(obj.getMaxSum(naSum));
		List<Return> saList =  obj.getReturnByRegion(Region.SA);
		Map<Account,Double> saSum = obj.getSum(saList);
		System.out.println("Sum of SA");
		saSum.entrySet().forEach(System.out::println);
		System.out.println(obj.getMaxSum(saSum));
		System.out.println(obj.getMaxSum(naSum).getRet_value() - obj.getMaxSum(saSum).getRet_value());
	}

}

enum Region{
	SA,NA
}

enum Account{
	SB_1001,SB_1002,SB_1003,SB_1004,SB_1005
}

class ReturnSum{
	private Account account;
	private double ret_value;
	public ReturnSum(Account account, double ret_value) {
		super();
		this.account = account;
		this.ret_value = ret_value;
	}
	public Account getAccount() {
		return account;
	}
	public double getRet_value() {
		return ret_value;
	}
	@Override
	public String toString() {
		return "ReturnSum [account=" + account + ", ret_value=" + ret_value + "]";
	}
	
}


class Return{
	private Date date;
	private Account account;
	private Region region;
	private double ret_value;
	
	public Return(Date date, Account account, Region region, double ret_value) {
		super();
		this.date = date;
		this.account = account;
		this.region = region;
		this.ret_value = ret_value;
	}

	public Date getDate() {
		return date;
	}

	public Account getAccount() {
		return account;
	}

	public Region getRegion() {
		return region;
	}

	public double getRet_value() {
		return ret_value;
	}

	@Override
	public String toString() {
		return "Return [date=" + date + ", account=" + account + ", region=" + region + ", ret_value=" + ret_value
				+ "]";
	}
	
}
