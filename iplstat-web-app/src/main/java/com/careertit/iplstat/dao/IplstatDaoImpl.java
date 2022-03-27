package com.careertit.iplstat.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.careertit.iplstat.dto.TeamStatDto;
import com.careertit.iplstat.util.ConnectionUtil;

public class IplstatDaoImpl implements IplstatDao {

	private static IplstatDaoImpl iplStatDao;
	private ConnectionUtil conUtil = ConnectionUtil.obj;
	
	private static final String TEAM_NAMES = "select team_code from team";
	private static final String TEAM_STAT = "select t.team_code as teamCode,t.team_name as teamName,sum(p.price) totalAmount,count(1) as playerCount,round(avg(p.price::decimal),2) avgAmount from player p inner join team t on p.team=t.team_code group by t.team_code;";
	private IplstatDaoImpl() {
	}
	@Override
	public List<String> selectTeamNames() {
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
		}finally {
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
				TeamStatDto obj = TeamStatDto.builder()
						                    .totalAmount(totalAmount)  
											.avgAmount(avgAmount)
											.teamCode(teamCode)
											.teamName(teamName)
											.playerCount(count).build();
				
				teamStatList.add(obj);
			}
		} catch (SQLException e) {
			System.out.println("While getting team names:" + e);
		}finally {
			conUtil.close(rs, st, con);
		}
		return teamStatList;
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
}
