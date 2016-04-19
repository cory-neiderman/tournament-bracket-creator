package com.techelevator.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCTournamentDAO implements TournamentDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCTournamentDAO(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void createTournament(Tournament tournament) {
		
		String insertTournament = "INSERT INTO tournament(sport, tournament_name, start_date, end_date, max_teams, app_user_id) "+
				"VALUES(?,?,?,?,?,?)";
		
		jdbcTemplate.update(insertTournament, tournament.getSport(), tournament.getTournamentName(), tournament.getStartDate(), tournament.getEndDate(), tournament.getMaxTeams(), tournament.getUserId());
		
	}
		
	

}
