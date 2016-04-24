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

	@Override
	public List<Game> getGameListByTournamentId(int tournamentId) {
		
		List<Game> gameList = new ArrayList<>();
		
		String sqlQueryForCompetitor1Name = "SELECT game.game_number, game.tournament_id, game.competitor_1, game.competitor_2, competitor.competitor_name "
				+ "FROM game "
				+ "INNER JOIN competitor "
				+ "ON game.competitor_1=competitor.competitor_id "
				+ "WHERE game.tournament_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryForCompetitor1Name, tournamentId);
		
		while (results.next()) {
			Game game = new Game();
			game.setGameNumber(results.getInt("game_number"));
			game.setTournamentId(tournamentId);
			game.setCompetitor1Name(results.getString("competitor_name"));
			String sqlQueryForCompetitor2Name = "SELECT game.competitor_2, competitor.competitor_name "
					+ "FROM competitor "
					+ "INNER JOIN game "
					+ "ON game.competitor_2=competitor.competitor_id "
					+ "WHERE competitor_2=?";
			
			SqlRowSet nextResults = jdbcTemplate.queryForRowSet(sqlQueryForCompetitor2Name, results.getInt("competitor_2"));
			nextResults.next();
			game.setCompetitor2Name(nextResults.getString("competitor_name"));
			gameList.add(game);
			
		}
		
		return gameList;
	}

}
