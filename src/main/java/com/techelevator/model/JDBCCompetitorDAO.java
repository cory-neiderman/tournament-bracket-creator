package com.techelevator.model;

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
			String insertCompetitors = "INSERT INTO competitor(competitor_name) VALUES(?)";
			jdbcTemplate.update(insertCompetitors, competitor );
		}
		
	}
	
	@Override
	public void enterCompetitorsIntoCompetitiorTournament(String[] competitors, int tournamentId) {
		
		
		for(String competitor : competitors){
			
			String getCompetitorIDByNAme = "SELECT competitor_id FROM competitor WHERE competitor_name = ?";
			SqlRowSet results = jdbcTemplate.queryForRowSet(getCompetitorIDByNAme, competitor);
			results.next();
			int competitorId=results.getInt("competitor_id");
			String insertIntoTable ="INSERT INTO competitor_tournament(competitor_id, tournament_id) VALUES(?,?)";
			jdbcTemplate.update(insertIntoTable, competitorId, tournamentId);
			
		}
				
	}

}
