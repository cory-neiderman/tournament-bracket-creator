package com.techelevator.model;

public interface CompetitorDAO {
	
	public void enterCompetitors(String[] competitors);

	int getCompetitorIdByName(String competitorName);

}
