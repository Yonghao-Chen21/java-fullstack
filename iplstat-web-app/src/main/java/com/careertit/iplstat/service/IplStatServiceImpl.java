package com.careertit.iplstat.service;

import java.util.List;

import com.careertit.iplstat.dao.IplstatDao;
import com.careertit.iplstat.dao.IplstatDaoImpl;
import com.careertit.iplstat.dto.TeamStatDto;

public class IplStatServiceImpl implements IplStatService {

	private IplstatDao obj = IplstatDaoImpl.getInstance();

	@Override
	public List<String> getTeamNames() {
		List<String> list = obj.selectTeamNames();
		System.out.println("Total team names count is :" + list.size());
		return list;
	}

	@Override
	public List<TeamStatDto> getTeamStats() {
		List<TeamStatDto> list = obj.selectTeamStats();
		System.out.println("Teams count is :" + list.size());
		return list;
	}

}
