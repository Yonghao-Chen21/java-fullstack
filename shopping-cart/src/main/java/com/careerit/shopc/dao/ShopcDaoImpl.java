package com.careerit.shopc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.careerit.shopc.domain.Item;
import com.careerit.shopc.util.ConnectionUtil;

public class ShopcDaoImpl implements ShopcDao{
	private static ShopcDaoImpl ShopcDao;
	private ConnectionUtil conUtil = ConnectionUtil.obj;
	private static final String ALL_ITEMS = "select * from item";
	private static final String GET_ITEM = "select * from item where name=?";
	
	private ShopcDaoImpl(){
		
	}
	
	public static ShopcDaoImpl getInstance() {

		if (ShopcDao == null) {
			synchronized (ShopcDao.class) {
				if (ShopcDao == null) {
					ShopcDao = new ShopcDaoImpl();
				}
			}
		}
		return ShopcDao;
		
	}

	
	@Override
	public List<Item> loadItems() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<Item> items = new ArrayList<>();
		try {
			con = conUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(ALL_ITEMS);
			while(rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				Item i = Item.builder().id(id).name(name).price(price).build();
				items.add(i);				
			}
		} catch (SQLException e) {
			System.out.println("While getting items:" + e);
		} finally {
			conUtil.close(rs, st, con);
		}
		
		return items;
	}

	@Override
	public Item loadItemFromName(String name) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Item i = null;
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(GET_ITEM);
			pst.setString(1, name);
			rs = pst.executeQuery();
			while(rs.next()) {
				Long id = rs.getLong("id");
				double price = rs.getDouble("price");
				i = Item.builder().id(id).name(name).price(price).build();				
			}
		} catch (SQLException e) {
			System.out.println("While getting item:" + e);
		}finally {
			conUtil.close(rs, pst, con);
		}
		return i;
	}

}
