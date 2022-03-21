package com.careerit.iplstat.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.careerit.iplstat.domain.Team;

public enum CsvReaderUtilTeam {
	obj;

	public List<Team> loadTeams() {
		List<Team> list = new ArrayList<>();
		try {
			List<String> dlist = Files.readAllLines(Paths.get(CsvReaderUtil.class.getResource("/team.csv").toURI()));
			for (int i = 1; i < dlist.size(); i++) {
				String[] data = dlist.get(i).split(",");
				String teamCode = data[0];
				String teamName = data[1];
				list.add(new Team(teamCode,teamName));
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return list;
	}
}
