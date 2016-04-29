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
	private TournamentDAO tournamentDAO;
	
	
	@Autowired
	public JDBCGameDAO(DataSource dataSource, JDBCCompetitorDAO competitorDAO, JDBCTournamentDAO tournamentDAO) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.competitorDAO=competitorDAO;
		this.tournamentDAO=tournamentDAO;
		
	}

	@Override
	public void createGames(int maxTeams, int tournamentId) {
		int roundCount=0;
		int byes = getByes(maxTeams);
		int n = maxTeams;
		if(byes==0){
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
		else{
			roundCount++;
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
		
	}

	private int getByes(int maxTeams) {
		
		int[] knownBracket = {4,8,16,32,64,128};
		for(int i=0; i<knownBracket.length; i++){
			if(knownBracket[i]>=maxTeams){
				return knownBracket[i]-maxTeams;
			}
		}
		return 0;
	}

	@Override
	public void addTeamsToGames(String[] allCompetitors, int tournamentId) {
		int maxTeams = tournamentDAO.getMaxTeamsByTournamentId(tournamentId);
		int byes = getByes(maxTeams);
		if(byes!=0){
			int gameNumber=1;
			for(int i=0; i<maxTeams-byes; i=i+2){
				int competitorOneId=competitorDAO.getCompetitorIdByName(allCompetitors[i]);
				int competitorTwoId=competitorDAO.getCompetitorIdByName(allCompetitors[i+1]);
				
				String insertGame = "UPDATE game SET competitor_1 = ?, competitor_2 = ? WHERE tournament_id = ? AND game_number = ?";
				
				jdbcTemplate.update(insertGame, competitorOneId, competitorTwoId, tournamentId, gameNumber);
				gameNumber= gameNumber+1;
			}
		}
		else{
			int gameNumber=1;
			for(int i=0; i<allCompetitors.length-1; i=i+2){
				int competitorOneId=competitorDAO.getCompetitorIdByName(allCompetitors[i]);
				int competitorTwoId=competitorDAO.getCompetitorIdByName(allCompetitors[i+1]);
				
				String insertGame = "UPDATE game SET competitor_1 = ?, competitor_2 = ? WHERE tournament_id = ? AND game_number = ?";
				
				jdbcTemplate.update(insertGame, competitorOneId, competitorTwoId, tournamentId, gameNumber);
				gameNumber= gameNumber+1;
			}
		}
		
	}

	@Override
	public List<Game> getGameListByRoundAndTournamentId(int tournamentId, int round) {
		
		List<Game> gameList = new ArrayList<>();
		
		String sqlQueryForGames = "SELECT * FROM game WHERE tournament_id = ? AND round_number = ? ORDER BY game_number";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryForGames, tournamentId, round);
		
		while (results.next()) {
			Game game = new Game();
			game.setGameNumber(results.getInt("game_number"));
			game.setTournamentId(tournamentId);
			game.setCompetitor1Score(results.getString("competitor_1_score"));
			game.setCompetitor2Score(results.getString("competitor_2_score"));
			
			if(results.getString("competitor_1") == null){
				game.setCompetitor1Name("tba");
				
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
				
			}	
			if(results.getString("competitor_2") == null){
					game.setCompetitor2Name("tba");
				}
				else{
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
		
		
	

	@Override
	public List<Game> getGameListByTournamentId(int tournamentId) {
		List<Game> gameList = new ArrayList<>();
		
		String sqlQueryForGames = "SELECT * FROM game WHERE tournament_id = ? "
				+ "AND competitor_1 IS NOT NULL AND competitor_2 IS NOT NULL AND competitor_winner_id IS NULL ";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryForGames, tournamentId);
		
		while (results.next()) {
			Game game = new Game();
			game.setGameNumber(results.getInt("game_number"));
			game.setTournamentId(tournamentId);
			game.setGameId(results.getInt("game_id"));
			
			if(results.getString("competitor_1") == null){
				game.setCompetitor1Name("winner of previous");
				
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
				
				if(results.getString("competitor_2") == null){
					
					game.setCompetitor2Name("winner of previous");
				}
				else{
					String sqlQueryForCompetitor2Name = "SELECT game.competitor_2, competitor.competitor_name "
							+ "FROM competitor "
							+ "INNER JOIN game "
							+ "ON game.competitor_2=competitor.competitor_id "
							+ "WHERE competitor_2=?";
					
					SqlRowSet competitor2Results = jdbcTemplate.queryForRowSet(sqlQueryForCompetitor2Name, results.getInt("competitor_2"));
					competitor2Results.next();
					game.setCompetitor2Name(competitor2Results.getString("competitor_name"));
				}
			}
			gameList.add(game);
			
		}
		
		return gameList;
	}

	@Override
	public Game getGameByGameId(int gameId) {
		
		String sqlQueryForGames = "SELECT * FROM game WHERE game_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryForGames, gameId);
		
		results.next();
		Game game = new Game();
		game.setGameNumber(results.getInt("game_number"));
		game.setGameId(gameId);
		game.setRoundNumber(results.getInt("round_number"));
		game.setWinnerCompetitorId(results.getInt("competitor_winner_id"));
		
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
			game.setCompetitor1(competitor1Results.getInt("competitor_1"));
			String sqlQueryForCompetitor2Name = "SELECT game.competitor_2, competitor.competitor_name "
					+ "FROM competitor "
					+ "INNER JOIN game "
					+ "ON game.competitor_2=competitor.competitor_id "
					+ "WHERE competitor_2=?";
			
			SqlRowSet competitor2Results = jdbcTemplate.queryForRowSet(sqlQueryForCompetitor2Name, results.getInt("competitor_2"));
			competitor2Results.next();
			game.setCompetitor2(competitor2Results.getInt("competitor_2"));
			game.setCompetitor2Name(competitor2Results.getString("competitor_name"));
		}
		return game;
	}

	@Override
	public void recordScore(int winnerId, int competitor1Score, int competitor2Score, int gameId) {
		
		String sqlUpdateQuery = "UPDATE game SET competitor_1_score = ?, competitor_2_score = ?, competitor_winner_id = ? WHERE game_id = ?";
		
		jdbcTemplate.update(sqlUpdateQuery, competitor1Score, competitor2Score, winnerId, gameId);
		
	}

	@Override
	public void advanceWinner(Game game, int teams, int tournamentId) {
		
		
		
		
		int gameTrack=(int) (game.getGameNumber()-(teams-teams/Math.pow(2,(game.getRoundNumber()-1))));
		if(gameTrack%2==0){
			int nextGame=(int) (teams-teams/Math.pow(2,game.getRoundNumber()))+gameTrack/2;
			String sqlUpdateQuery = "UPDATE game SET competitor_2 = ?  WHERE game_number = ? AND tournament_id = ?";
			jdbcTemplate.update(sqlUpdateQuery, game.getWinnerCompetitorId(), nextGame, tournamentId);
			
		}
		else{
			gameTrack++;
			int nextGame=(int) (teams-teams/Math.pow(2,game.getRoundNumber()))+gameTrack/2;
			String sqlUpdateQuery = "UPDATE game SET competitor_1 = ?  WHERE game_number = ? AND tournament_id = ?";
			jdbcTemplate.update(sqlUpdateQuery, game.getWinnerCompetitorId(), nextGame, tournamentId);
		}
		
		
		
		
		
		
		if(teams-game.getGameNumber()==1){
			
			String sqlUpdateQuery = "UPDATE tournament SET champion_id = ?  WHERE  tournament_id = ?";
			jdbcTemplate.update(sqlUpdateQuery, game.getWinnerCompetitorId(), tournamentId);
		}
		
		
		
	}

	

}
