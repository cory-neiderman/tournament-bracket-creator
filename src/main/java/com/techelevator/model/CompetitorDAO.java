package com.techelevator.model;

import java.util.List;

public interface CompetitorDAO {
	
	public void enterCompetitors(String[] competitors);
	public void enterCompetitorsIntoCompetitorTournament(String[] competitors, int tournamentId);
	public boolean isCompetitorInDatabase(String competitorName);
	public int getCompetitorIdByName(String competitorName);
	public List<Competitor> getCompetitorListByTournamentId(int tournamentId);
	public String getNameById(int int1);

}
