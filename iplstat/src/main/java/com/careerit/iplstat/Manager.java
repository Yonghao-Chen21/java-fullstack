package com.careerit.iplstat;

import java.util.List;

import com.careerit.iplstat.domain.Player;
import com.careerit.iplstat.util.CsvReaderUtil;

public class Manager {

		public static void main(String[] args) {
			
				List<Player> players = CsvReaderUtil.obj.loadPlayers();
				System.out.println(players.size());
				
				players.forEach(p->{
					System.out.println(p.getName()+" "+p.getRole());
				});
		}
}
