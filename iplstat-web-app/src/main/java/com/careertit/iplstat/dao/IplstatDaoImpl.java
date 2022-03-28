package com.careertit.iplstat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.careertit.iplstat.domain.Player;
import com.careertit.iplstat.domain.PlayerRole;
import com.careertit.iplstat.dto.RoleAmountDTO;
import com.careertit.iplstat.dto.TeamStatDto;
import com.careertit.iplstat.util.ConnectionUtil;

public class IplstatDaoImpl implements IplstatDao {

	private static IplstatDaoImpl iplStatDao;
	private ConnectionUtil conUtil = ConnectionUtil.obj;
	private static final String TEAM_NAMES = "select team_code from team";
	private static final String TEAM_STAT = "select t.team_code as teamCode,t.team_name as teamName,sum(p.price) totalAmount,count(1) as playerCount,round(avg(p.price::decimal),2) avgAmount from player p inner join team t on p.team=t.team_code group by t.team_code;";
	private static final String TEAM_PLAYERS = "select pid,name,role,country,price,team from player p1 where team=? order by p1.role";
	private static final String ALL_ROLEAMOUNTS = "select p1.role,sum(p1.price) amount from player p1 group by p1.role order by p1.role;";
	private static final String TEAM_ROLEAMOUNTS = "select p1.team,p1.role,sum(p1.price) amount from player p1 group by p1.team,p1.role having team = ? order by p1.team,p1.role;";
	private static final String SEARCH_PLAYERS = "SELECT * FROM player p WHERE name like ?"; 
	
	private IplstatDaoImpl() {
	}

	public static IplstatDao getInstance() {

		if (iplStatDao == null) {
			synchronized (IplstatDaoImpl.class) {
				if (iplStatDao == null) {
					iplStatDao = new IplstatDaoImpl();
				}
			}
		}
		return iplStatDao;
	}
	
	@Override
	public List<String> selectTeamCodes() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<String> teamNames = new ArrayList<String>();
		try {
			con = conUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(TEAM_NAMES);
			while (rs.next()) {
				teamNames.add(rs.getString("team_code"));
			}
		} catch (SQLException e) {
			System.out.println("While getting team names:" + e);
		} finally {
			conUtil.close(rs, st, con);
		}
		return teamNames;
	}

	@Override
	public List<TeamStatDto> selectTeamStats() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List<TeamStatDto> teamStatList = new ArrayList<>();
		try {
			con = conUtil.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(TEAM_STAT);
			while (rs.next()) {
				String teamCode = rs.getString("teamCode");
				String teamName = rs.getString("teamName");
				double totalAmount = rs.getDouble("totalAmount");
				int count = rs.getInt("playerCount");
				double avgAmount = rs.getDouble("avgAmount");
				TeamStatDto obj = TeamStatDto.builder().totalAmount(totalAmount).avgAmount(avgAmount).teamCode(teamCode)
						.teamName(teamName).playerCount(count).build();

				teamStatList.add(obj);
			}
		} catch (SQLException e) {
			System.out.println("While getting team names:" + e);
		} finally {
			conUtil.close(rs, st, con);
		}
		return teamStatList;
	}

	@Override
	public List<Player> getPlayers(String teamCode) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Player> plist = new ArrayList<>();
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(TEAM_PLAYERS);
			pst.setString(1, teamCode);
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
	public List<RoleAmountDTO> getRoleAmount(String teamCode) {
		List<RoleAmountDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = conUtil.getConnection();
			if (teamCode.equals("ALL")) {
				pst = con.prepareStatement(ALL_ROLEAMOUNTS);
			} else {
				pst = con.prepareStatement(TEAM_ROLEAMOUNTS);
				pst.setString(1, teamCode);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				PlayerRole role = PlayerRole.valueOf(rs.getString("role").toUpperCase());
				double amount = rs.getDouble("amount");
				list.add(new RoleAmountDTO(role, amount));
			}
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(rs, pst, con);
		}
		return list;
	}

	@Override
	public List<Player> searchPlayer(String name) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Player> plist = new ArrayList<>();
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(SEARCH_PLAYERS);
			pst.setString(1, "%" + name + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				String pname = rs.getString("name");
				int pid = rs.getInt("pid");
				PlayerRole prole = PlayerRole.valueOf(rs.getString("role").toUpperCase());
				double price = rs.getDouble("price");
				String country = rs.getString("country");
				String team = rs.getString("team");
				Player player = Player.builder().pid(pid).name(pname).country(country).role(prole).price(price)
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
}
