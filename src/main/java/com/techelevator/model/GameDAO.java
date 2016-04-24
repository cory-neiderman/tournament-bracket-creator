package com.techelevator.model;

import java.util.List;

public interface GameDAO {
	
	

	void createGames(int maxTeams, int tournamentId);
	void addTeamsToGames(String[] allCompetitors, int tournamentId);
	//List<Game> getGameListByTournamentId(int tournamentId);

}
