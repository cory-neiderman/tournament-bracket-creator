package com.techelevator.model;

public interface GameDAO {
	
	

	void createGames(int maxTeams, int tournamentId);
	void addTeamsToGames(String[] allCompetitors, int tournamentId);

}
