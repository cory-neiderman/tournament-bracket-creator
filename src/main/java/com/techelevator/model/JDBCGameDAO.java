package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCGameDAO implements GameDAO {
	
	private JdbcTemplate jdbcTemplate;
	private CompetitorDAO competitorDAO;
	
	
	@Autowired
	public JDBCGameDAO(DataSource dataSource, JDBCCompetitorDAO competitorDAO) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.competitorDAO=competitorDAO;
		
	}

	@Override
	public void createGames(int maxTeams, int tournamentId) {
		
		for(int i=1; i<maxTeams; i++){
		String insertGame = "INSERT INTO game(tournament_id, game_number) "+
				"VALUES(?,?)";
		jdbcTemplate.update(insertGame, tournamentId, i);
		}
		
	}

	@Override
	public void addTeamsToGames(String[] allCompetitors, int tournamentId) {
		
		int gameNumber=1;
		for(int i=0; i<allCompetitors.length-1; i=i+2){
			int competitorOneId=competitorDAO.getCompetitorIdByName(allCompetitors[i]);
			int competitorTwoId=competitorDAO.getCompetitorIdByName(allCompetitors[i+1]);
			
			String insertGame = "UPDATE game SET competitor_1 = ?, competitor_2 = ? WHERE tournament_id = ? AND game_number = ?";
			
			jdbcTemplate.update(insertGame, competitorOneId, competitorTwoId, tournamentId, gameNumber);
			gameNumber= gameNumber+1;
		}
		
	}

	/*@Override
	public List<Game> getGameListByTournamentId(int tournamentId) {
		
		
		String getListOfGames = "SELECT * FROM game WHERE tournament_id = ?"; 
				

		SqlRowSet results = jdbcTemplate.queryForRowSet(getListOfGames, tournamentId);
		List<Game> gameList = new ArrayList<>();
		while (results.next()) {
			Game game = new Game();
			game.setGameNumber(results.getInt("game_number"));
			//game.setCompetitor1Name(competitorDAO.getNameById(results.getInt("competitor_1")));
			//game.setCompetitor2Name(competitorDAO.getNameById(results.getInt("competitor_2")));
		}
		
		return gameList;
	}*/

}
