package com.careerit.iplstat.dao;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.careertit.iplstat.dao.IplstatDao;
import com.careertit.iplstat.dao.IplstatDaoImpl;
import com.careertit.iplstat.domain.Player;
import com.careertit.iplstat.dto.RoleAmountDTO;
import com.careertit.iplstat.dto.TeamStatDto;

public class IplStatDaoTest {

	@Test
	public void teamCount() {
		IplstatDao iplstatDao = IplstatDaoImpl.getInstance();
		List<String> teamNames = iplstatDao.selectTeamCodes();
		int expected = 10;

		Object[] expArr = { "RCB", "MI", "CSK", "DC", "RR", "SRH", "PBKS", "KKR", "GT", "LSG" };
		Object[] actArr = teamNames.toArray();
		assertEquals(expected, teamNames.size());
		assertArrayEquals(expArr, actArr);

	}

	@Test
	public void teamStatTest() {
		IplstatDao iplstatDao = IplstatDaoImpl.getInstance();
		List<TeamStatDto> list = iplstatDao.selectTeamStats();
		int expected = 10;
		assertEquals(expected, list.size());
		TeamStatDto obj = list.get(0);
		assertEquals("KKR", obj.getTeamCode());
	}

	@Test
	public void getPlayersTest() {
		IplstatDao iplstatDao = IplstatDaoImpl.getInstance();
		List<Player> list = iplstatDao.getPlayers("GT");
		int expected = 23;
		assertEquals(expected, list.size());
		Player player = list.get(0);
		assertEquals("GurkeeratSinghMann", player.getName());
	}

	@Test
	public void getRoleAmountTest() {
		IplstatDao iplstatDao = IplstatDaoImpl.getInstance();
		List<RoleAmountDTO> list = iplstatDao.getRoleAmount("ALL");
		int expected = 4;
		assertEquals(expected, list.size());
		RoleAmountDTO obj = list.get(0);
		assertEquals(0, obj.getAmount());
	}
	
	@Test
	public void searchPlayerTest() {
		IplstatDao iplstatDao = IplstatDaoImpl.getInstance();
		List<Player> list = iplstatDao.searchPlayer("ham");
		int expected = 12;
		assertEquals(expected, list.size());
	}

}
