package com.techelevator.model;

import java.util.List;

public interface TournamentDAO {

	public void createTournament(Tournament tournament);
	public List<Tournament> getListOfTournamentsByUserId(int userId);
	public int getMaxTeamsByTournamentId(int tournamentId);
	
}
