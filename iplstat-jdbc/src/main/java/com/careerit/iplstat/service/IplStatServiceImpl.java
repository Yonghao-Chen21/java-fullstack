package com.careerit.iplstat.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.careerit.iplstat.domain.Player;
import com.careerit.iplstat.domain.PlayerRole;
import com.careerit.iplstat.dto.PlayerTeamDTO;
import com.careerit.iplstat.dto.RoleAmountDTO;
import com.careerit.iplstat.util.ConnectionUtil;

public class IplStatServiceImpl implements IplStatService {

	private ConnectionUtil conUtil = ConnectionUtil.obj;
	public String sql_str = "select pid,name,role,country,price,team from player p1";

	public List<Player> getPlayers(String sql_tail, String[] rules) {
		// add the rest part of sql query
		String sql = sql_str + sql_tail;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Player> plist = new ArrayList<>();
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(sql);
			// set the rules from inputs
			int i = 1;
			for (String rule : rules) {
				pst.setString(i, rule);
				i++;
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("pid");
				String name = rs.getString("name");
				PlayerRole prole = PlayerRole.valueOf(rs.getString("role").toUpperCase());
				double price = rs.getDouble("price");
				String country = rs.getString("country");
				String team = rs.getString("team");
				Player player = Player.builder().pid(pid).name(name).country(country).role(prole).price(price)
						.team(team).build();
				plist.add(player);
			}
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(rs, pst, con);
		}
		return plist;
	}

	@Override
	public List<Player> getPlayers(String teamName) {
		return getPlayers(" where team=?", new String[] { teamName });
	}

	@Override
	public List<Player> getPlayers(String teamName, String role) {
		return getPlayers(" where team=? and role=?", new String[] { teamName, role });
	}

	@Override
	public List<Player> getPlayers(String teamName, String role, String country) {
		// TODO Auto-generated method stub
		return getPlayers(" where team=? and role=? and country=?", new String[] { teamName, role, country });
	}

	@Override
	public List<Player> getMaxPaidPlayers(String teamName) {
		return getPlayers(
				" where p1.price = (select max(p2.price) from player p2 where p2.team = p1.team) and p1.team = ?",
				new String[] { teamName });
	}

	@Override
	public List<Player> getMaxPaidPlayers(String teamName, String role) {
		return getPlayers(
				" where p1.price = (select max(p2.price) from player p2 where p2.team = p1.team) and p1.team = ? and p1.role = ?",
				new String[] { teamName, role });
	}

	@Override
	public List<Player> getMaxPaidPlayers() {
		return getPlayers(" where p1.price = (select max(p2.price) from player p2)", new String[] {});
	}

	public Map<PlayerRole, Double> getAmountSpentByEachRoleSql(String sql, String[] rules) {
		Map<PlayerRole, Double> map = new HashMap<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(sql);
			// set the rules from inputs
			int i = 1;
			for (String rule : rules) {
				pst.setString(i, rule);
				i++;
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				PlayerRole role = PlayerRole.valueOf(rs.getString("role").toUpperCase());
				double sum = rs.getDouble("sum");
				map.put(role, sum);
			}
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(rs, pst, con);
		}
		return map;
	}

	@Override
	public Map<PlayerRole, Double> getAmountSpentByEachRole(String teamName) {
		return getAmountSpentByEachRoleSql("select p1.role,sum(p1.price) from player p1 where team=? group by p1.role",
				new String[] { teamName });
	}

	@Override
	public Map<PlayerRole, Double> getAmountSpentByEachRole() {
		return getAmountSpentByEachRoleSql("select p1.role,sum(p1.price) from player p1 group by p1.role",
				new String[] {});
	}

	@Override
	public List<Player> getAllPlayersSortByAmount() {
		return getPlayers(" order by p1.price", new String[] {});
	}

	@Override
	public Map<String, List<RoleAmountDTO>> getTeamRoleAmount() {
		Map<String, List<RoleAmountDTO>> map = new HashMap<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement("select p1.team,p1.role,sum(p1.price) from player p1 group by p1.team,p1.role");
			rs = pst.executeQuery();
			while (rs.next()) {
				String team = rs.getString("team");
				PlayerRole role = PlayerRole.valueOf(rs.getString("role").toUpperCase());
				double sum = rs.getDouble("sum");
				//map.compute(team,(k,v)->v==null?new ArrayList<RoleAmountDTO>():v.add(new RoleAmountDTO(role, sum)));
				map.putIfAbsent(team, new ArrayList<RoleAmountDTO>());
				map.get(team).add(new RoleAmountDTO(role, sum));
			}
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(rs, pst, con);
		}
		return map;
	}

	@Override
	public List<PlayerTeamDTO> getPlayerWithTeamDetails() {
		String sql = "select p1.name,p1.role,p1.team,t1.team_name,p1.price from player p1 inner join team t1 on p1.team = t1.team_code";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<PlayerTeamDTO> plist = new ArrayList<>();
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				PlayerRole prole = PlayerRole.valueOf(rs.getString("role").toUpperCase());
				String team_code = rs.getString("team");
				String team_name = rs.getString("team_name");
				double price = rs.getDouble("price");
				PlayerTeamDTO ele = PlayerTeamDTO.builder().name(name).teamName(team_name).teamCode(team_code)
						.price(price).role(prole).build();
				plist.add(ele);
			}
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(rs, pst, con);
		}
		return plist;
	}

}
