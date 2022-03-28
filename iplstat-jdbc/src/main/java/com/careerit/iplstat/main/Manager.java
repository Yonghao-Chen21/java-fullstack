package com.careerit.iplstat.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.careerit.iplstat.util.ConnectionUtil;

public class Manager {

	public static void main(String[] args) {

		//createTable();
		//addEmployee(1,"As",500);
		//showEmployees();
		//updateSalary(5);
		//showEmployees();

	}

	private static ConnectionUtil conUtil = ConnectionUtil.obj;

	private static void updateSalary(int per) {

		String str = "update emp set sal =  sal + sal * ? / 100";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(str);
			pst.setFloat(1, per);
			int count = pst.executeUpdate();
			System.out.println(count + " record(s) updated");
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(pst, con);
		}
	}

	private static void deleteEmployee(int empno) {

		String str = "delete from emp where empno=?";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(str);
			pst.setInt(1, empno);
			int count = pst.executeUpdate();
			System.out.println(count + " record(s) updated");
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(pst, con);
		}
	}

	private static void showEmployees() {

		String str = "select empno,ename,sal from emp";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = conUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(str);
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				float sal = rs.getFloat("sal");
				System.out.println(empno + " " + name + " " + sal);
			}

		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(rs, st, con);
		}
	}

	private static void addEmployee(int empno, String name, float sal) {
		
		String str = "insert into emp(empno,ename,sal) values(?,?,?);";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(str);
			pst.setInt(1, empno);
			pst.setString(2, name);
			pst.setFloat(3, sal);
			int count = pst.executeUpdate();
			System.out.println(count + " record(s) updated");
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(pst, con);
		}
	}

	private static void createTable() {
		String str = "create table emp(empno int,ename varchar(100),sal float);";
		Connection con = null;
		Statement st = null;
		try {
			con = conUtil.getConnection();
			st = con.createStatement();
			boolean res = st.execute(str);
			System.out.println("Table creation status :"+res);
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(st, con);
		}
	}
}
