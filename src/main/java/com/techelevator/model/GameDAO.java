package com.techelevator.model;

import java.util.List;

public interface GameDAO {
	
	

	void createGames(int maxTeams, int tournamentId);
	void addTeamsToGames(String[] allCompetitors, int tournamentId);
	List<Game> getGameListByRoundAndTournamentId(int tournamentId, int i);
	List<Game> getGameListByTournamentId(int tournamentId);
	Game getGameByGameId(int gameId);
	void recordScore(int winnerId, int competitor1Score, int competitor1Score2, int gameId);

}
