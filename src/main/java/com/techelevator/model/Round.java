package com.techelevator.model;

import java.util.List;

public class Round {

	private int roundNumber;
	private List<Game> gamesInRound;
	
	public int getRoundNumber() {
		return roundNumber;
	}
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	public List<Game> getGamesInRound() {
		return gamesInRound;
	}
	public void setGamesInRound(List<Game> gamesInRound) {
		this.gamesInRound = gamesInRound;
	}
	
}
