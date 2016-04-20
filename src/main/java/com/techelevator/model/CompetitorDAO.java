package com.techelevator.model;

public interface CompetitorDAO {
	
	public void enterCompetitors(String[] competitors);


	public void enterCompetitorsIntoCompetitiorTournament(String[] competitors, int tournamentId);

}
