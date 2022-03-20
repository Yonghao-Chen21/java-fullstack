package com.careerit.iplstat.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public enum ConnectionUtil {
	obj;
	private static Properties properties;
	static {
		properties = new Properties();
		try {
			properties.load(ConnectionUtil.class.getResourceAsStream("/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),properties.getProperty("password"));
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		}
		return con;
	}

	public void close(ResultSet rs, Statement st, Connection con) {
		try {

			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("Trying close resource which is not opened " + e);
		}
	}

	public void close(Statement st, Connection con) {
		try {
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("Trying close resource which is not opened " + e);
		}
	}
}
