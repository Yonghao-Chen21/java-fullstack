package com.careerit.iplstat.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.careerit.iplstat.domain.Player;
import com.careerit.iplstat.domain.Team;

public class CsvImportDb {
	
	private static ConnectionUtil conUtil = ConnectionUtil.obj;
	
	private static void addTeam(List<Team> teams) {
		
		String str = "insert into team(team_code,team_name) values(?,?);";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conUtil.getConnection();
			for(Team team : teams) {
				pst = con.prepareStatement(str);
				pst.setString(1, team.getTeamCode());
				pst.setString(2, team.getTeamName());
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(pst, con);
		}
	}
	
	private static void addPlayer(List<Player> players) {
		
		String str = "insert into player(name,role,price,country,team) values(?,?,?,?,?);";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conUtil.getConnection();
			for(Player player : players) {
				pst = con.prepareStatement(str);
				pst.setString(1, player.getName());
				pst.setString(2, player.getRole().name());
				pst.setFloat(3, (float)player.getPrice());
				pst.setString(4, player.getCountry());
				pst.setString(5, player.getTeam());
				pst.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(pst, con);
		}
	}

	public static void main(String[] args) {
		List<Team> teams = CsvReaderUtil.obj.loadTeams();
		List<Player> players = CsvReaderUtil.obj.loadPlayers();
		addPlayer(players);
		addTeam(teams);
		

	}
}
