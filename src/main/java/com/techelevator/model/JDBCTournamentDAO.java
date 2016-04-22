package com.techelevator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
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
	@Override
	public List<Tournament> getListOfTournamentsThatNeedTeamsByUserId(int userId) {
		
		
		List<Tournament> tournamentList = new ArrayList<Tournament>();
		
		String selectTournamentsByUser = "SELECT * FROM tournament WHERE app_user_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(selectTournamentsByUser, userId);
		
		while (results.next()) {
			Tournament tournament = new Tournament();
			tournament.setSport(results.getString("sport"));
			tournament.setTournamentName(results.getString("tournament_name"));
			tournament.setStartDate(LocalDate.parse(results.getString("start_date")));
			tournament.setEndDate(LocalDate.parse(results.getString("end_date")));
			tournament.setMaxTeams(results.getInt("max_teams"));
			tournament.setTournamentId(results.getInt("tournament_id"));
			String checkTournamentForTeams = "SELECT COUNT(tournament_id) team_count FROM competitor_tournament WHERE tournament_id = ?";
			
			SqlRowSet teamResults = jdbcTemplate.queryForRowSet(checkTournamentForTeams, tournament.getTournamentId());
			teamResults.next();
			int numberOfTeams = teamResults.getInt("team_count");
			
			if(numberOfTeams != tournament.getMaxTeams()) {
				tournamentList.add(tournament);
			}
		}
		
		return tournamentList;
		
	}
	@Override
	public int getMaxTeamsByTournamentId(int tournamentId) {
		
		String findMaxTeams = "SELECT max_teams FROM tournament WHERE tournament_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(findMaxTeams, tournamentId);
		results.next();
		
		int maxTeams = results.getInt("max_teams");
		
		return maxTeams;
	}
	@Override
	public List<Tournament> getListOfAllTournaments() {
		
		List<Tournament> tournamentList = new ArrayList<>();
		String getAllTournaments = "SELECT * from tournament";
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllTournaments);
		
		while(results.next()){
			Tournament tournament = new Tournament();
			tournament.setTournamentName(results.getString("tournament_name"));
			tournament.setTournamentId(results.getInt("tournament_id"));
			tournamentList.add(tournament);
		}
		
		return tournamentList;
	}
	
	@Override
	public Tournament getTournamentById(int tournamentId) {
		
		String getTournament = "SELECT * FROM tournament WHERE tournament_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(getTournament, tournamentId);
		results.next();
		Tournament tournament = new Tournament();
		tournament.setSport(results.getString("sport"));
		tournament.setTournamentName(results.getString("tournament_name"));
		tournament.setStartDate(LocalDate.parse(results.getString("start_date")));
		tournament.setEndDate(LocalDate.parse(results.getString("end_date")));
		tournament.setMaxTeams(results.getInt("max_teams"));
		tournament.setTournamentId(results.getInt("tournament_id"));
		
		return tournament;
	}
		
	

}
