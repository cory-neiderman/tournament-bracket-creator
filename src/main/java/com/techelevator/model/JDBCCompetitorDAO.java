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
	
	/*@Override
	public int getCompetitorIdByName(String competitorName) {
		
		Competitor competitor = new Competitor();
		
		String getCompetitorId = "SELECT competitor_id FROM competitor WHERE competitor_name = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(getCompetitorId, competitorName);
		
		return 0;
		
	}*/

}
