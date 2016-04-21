package com.techelevator.model;

import java.util.List;

public interface CompetitorDAO {
	
	public void enterCompetitors(String[] competitors);


	public void enterCompetitorsIntoCompetitiorTournament(String[] competitors, int tournamentId);


	public List<Competitor> getCompetitorListByTournamentId(int tournamentId);

}
