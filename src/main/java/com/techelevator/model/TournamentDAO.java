package com.techelevator.model;

import java.util.List;

public interface TournamentDAO {

	public void createTournament(Tournament tournament);
	public List<Tournament> getListOfTournamentsThatNeedTeamsByUserId(int userId);
	public int getMaxTeamsByTournamentId(int tournamentId);
	public List<Tournament> getListOfAllTournaments();
	public Tournament getTournamentById(int tournamentId);
	
}
