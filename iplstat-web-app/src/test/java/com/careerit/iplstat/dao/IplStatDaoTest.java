package com.careerit.iplstat.dao;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.careertit.iplstat.dao.IplstatDao;
import com.careertit.iplstat.dao.IplstatDaoImpl;
import com.careertit.iplstat.dto.TeamStatDto;

public class IplStatDaoTest {

	
		@Test
		public void teamCount() {
			IplstatDao iplstatDao = IplstatDaoImpl.getInstance();
			List<String> teamNames = iplstatDao.selectTeamNames();
			int expected = 4;
			
			Object[] expArr = {"CSK","SRH", "PBKS", "LSG"};
			Object[] actArr = teamNames.toArray();
			assertEquals(expected, teamNames.size());
			assertArrayEquals(expArr, actArr);
			
		}
		@Test
		public void teamStatTest() {
			IplstatDao iplstatDao = IplstatDaoImpl.getInstance();
			List<TeamStatDto> list = iplstatDao.selectTeamStats();
			int expected = 4;
			assertEquals(expected, list.size());
			TeamStatDto obj = list.get(0);
			assertEquals("SRH",obj.getTeamCode());
		}
}
