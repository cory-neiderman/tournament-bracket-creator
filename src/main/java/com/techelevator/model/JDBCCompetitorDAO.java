package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCCompetitorDAO implements CompetitorDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCCompetitorDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void enterCompetitors(String[] competitors) {
		for(String competitor: competitors){
			if(!isCompetitorInDatabase(competitor)){
				String insertCompetitors = "INSERT INTO competitor(competitor_name) VALUES(?)";
				jdbcTemplate.update(insertCompetitors, competitor );
			}
		}
		
	}
	
	@Override
	public void enterCompetitorsIntoCompetitorTournament(String[] competitors, int tournamentId) {
		
		
		for(String competitor : competitors){
			
			String getCompetitorIdByName = "SELECT competitor_id FROM competitor WHERE UPPER(competitor_name) = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(getCompetitorIdByName, competitor.toUpperCase());
			results.next();
			int competitorId=results.getInt("competitor_id");
			String insertIntoTable ="INSERT INTO competitor_tournament(competitor_id, tournament_id) VALUES(?,?)";
			jdbcTemplate.update(insertIntoTable, competitorId, tournamentId);
			
		}
				
	}

	@Override
	public List<Competitor> getCompetitorListByTournamentId(int tournamentId) {
		
		List<Competitor> competitorList = new ArrayList<>();
		
		String getListOfCompetitors = 	"SELECT * " + 
										"FROM competitor " + 
										"INNER JOIN " + 
										"(competitor_tournament INNER JOIN tournament " + 
										"ON tournament.tournament_id = competitor_tournament.tournament_id) " + 
										"ON competitor.competitor_id = competitor_tournament.competitor_id " + 
										"AND competitor_tournament.tournament_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(getListOfCompetitors, tournamentId);
		
		while (results.next()) {
			Competitor competitor = new Competitor();
			competitor.setCompetitorId(results.getInt("competitor_id"));
			competitor.setCompetitorName(results.getString("competitor_name"));	
			competitorList.add(competitor);
			
		}
		 
		return competitorList;
	}

	@Override
	public boolean isCompetitorInDatabase(String competitorName) {
		String sqlSearchForCompetitor = "SELECT * FROM competitor WHERE UPPER(competitor_name) = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForCompetitor, competitorName.toUpperCase());
		if(results.next()){
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public int getCompetitorIdByName(String competitorName) {
		String sqlSearchForCompetitor = "SELECT * FROM competitor WHERE UPPER(competitor_name) = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForCompetitor, competitorName.toUpperCase());
		
		return results.getInt("competitor_id");
	}

}
