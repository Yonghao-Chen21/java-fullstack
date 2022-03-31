package com.careerit.shopc.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.careerit.shopc.domain.Item;

public class CsvImportDb {

	private static ConnectionUtil conUtil = ConnectionUtil.obj;

	private static void addItems(List<Item> items) {

		String str = "insert into item(name,price) values(?,?);";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conUtil.getConnection();
			for (Item i : items) {
				pst = con.prepareStatement(str);
				pst.setString(1, i.getName());
				pst.setDouble(2, i.getPrice());
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(pst, con);
		}
	}

	public static void main(String[] args) {
		List<Item> items = CsvReaderUtil.obj.loadItems();
		addItems(items);
	}
}
