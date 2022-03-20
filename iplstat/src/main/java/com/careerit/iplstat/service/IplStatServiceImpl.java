package com.careerit.iplstat.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.careerit.iplstat.domain.Player;
import com.careerit.iplstat.domain.PlayerRole;
import com.careerit.iplstat.dto.PlayerTeamDTO;
import com.careerit.iplstat.dto.RoleAmountDTO;
import com.careerit.iplstat.util.ConnectionUtil;

public class IplStatServiceImpl implements IplStatService {

	private ConnectionUtil conUtil = ConnectionUtil.obj;
	
	@Override
	public List<Player> getPlayers(String teamName) {
		String sql_str = "select pid,name,role,country,price,team from emp where team=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Player> plist = new ArrayList<>();
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(sql_str);
			pst.setString(1,teamName);
			rs = pst.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				String name = rs.getString("name");
				PlayerRole prole = PlayerRole.valueOf(rs.getString("role").toUpperCase());
				double price = rs.getDouble("price");
				String country = rs.getString("country");
				Player player = Player.builder().pid(pid).name(name).country(country).role(prole).price(price).team(teamName).build();
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
	public List<Player> getPlayers(String teamName, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayers(String teamName, String role, String country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getMaxPaidPlayers(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getMaxPaidPlayers(String teamName, String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getMaxPaidPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getAmountSpentByEachRole(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getAmountSpentByEachRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getAllPlayersSortByAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<RoleAmountDTO>> getTeamRoleAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerTeamDTO> getPlayerWithTeamDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
