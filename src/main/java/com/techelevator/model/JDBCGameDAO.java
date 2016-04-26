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
		int roundCount=0;
		int n = maxTeams;
		while(n>1){
			n=n/2;
			roundCount=roundCount+1;
		}
		int currentRound=1;
		for(int i=1; i<maxTeams; i++){
			
			if(i==maxTeams-1){
				currentRound=roundCount;
			}
			else if(i>=maxTeams-3 && i<=maxTeams-2){
				currentRound=roundCount-1;
			}
			else if(i>=maxTeams-7 && i<=maxTeams-4){
				currentRound=roundCount-2;
			}
			else if(i>=maxTeams-15 && i<=maxTeams-8){
				currentRound=roundCount-3;
			}
			else if(i>=maxTeams-31 && i<=maxTeams-16){
				currentRound=roundCount-4;
			}
			else if(i>=maxTeams-63 && i<=maxTeams-32){
				currentRound=roundCount-5;
			}
			
			String insertGame = "INSERT INTO game(tournament_id, game_number, round_number) "+
				"VALUES(?,?,?)";
			
		jdbcTemplate.update(insertGame, tournamentId, i, currentRound);
		
		
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
	public List<Game> getGameListByRoundAndTournamentId(int tournamentId, int round) {
		
		List<Game> gameList = new ArrayList<>();
		
		String sqlQueryForGames = "SELECT * FROM game WHERE tournament_id = ? AND round_number = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryForGames, tournamentId, round);
		
		while (results.next()) {
			Game game = new Game();
			game.setGameNumber(results.getInt("game_number"));
			game.setTournamentId(tournamentId);
			if(results.getString("competitor_1") == null){
				game.setCompetitor1Name("winner of previous");
				game.setCompetitor2Name("winner of previous");
			}
			else{
				String sqlQueryForCompetitor1Name = "SELECT game.competitor_1, competitor.competitor_name "
						+ "FROM competitor "
						+ "INNER JOIN game "
						+ "ON game.competitor_1=competitor.competitor_id "
						+ "WHERE competitor_1=?";
				
				SqlRowSet competitor1Results = jdbcTemplate.queryForRowSet(sqlQueryForCompetitor1Name, results.getInt("competitor_1"));
				competitor1Results.next();
				game.setCompetitor1Name(competitor1Results.getString("competitor_name"));
				
				String sqlQueryForCompetitor2Name = "SELECT game.competitor_2, competitor.competitor_name "
						+ "FROM competitor "
						+ "INNER JOIN game "
						+ "ON game.competitor_2=competitor.competitor_id "
						+ "WHERE competitor_2=?";
				
				SqlRowSet competitor2Results = jdbcTemplate.queryForRowSet(sqlQueryForCompetitor2Name, results.getInt("competitor_2"));
				competitor2Results.next();
				game.setCompetitor2Name(competitor2Results.getString("competitor_name"));
			}
			gameList.add(game);
			
		}
		
		return gameList;
	}

	

}
