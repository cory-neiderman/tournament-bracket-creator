package com.techelevator.model;

import java.time.LocalDate;

public class Game {
	
	private int gameId;
	private int gameNumber;
	private int tournamentId;
	private int competitor1;
	private String competitor1Name;
	private String competitor2Name;
	private int competitor2;
	private int competitor1Score;
	private int competitor2Score;
	private int winnerCompetitorId;
	private LocalDate date;
	private int roundNumber;
	
	
	public int getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
	public int getCompetitor1() {
		return competitor1;
	}
	public void setCompetitor1(int competitor1) {
		this.competitor1 = competitor1;
	}
	public int getCompetitor2() {
		return competitor2;
	}
	public void setCompetitor2(int competitor2) {
		this.competitor2 = competitor2;
	}
	public int getCompetitor1Score() {
		return competitor1Score;
	}
	public void setCompetitor1Score(int competitor1Score) {
		this.competitor1Score = competitor1Score;
	}
	public int getCompetitor2Score() {
		return competitor2Score;
	}
	public void setCompetitor2Score(int competitor2Score) {
		this.competitor2Score = competitor2Score;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getGameNumber() {
		return gameNumber;
	}
	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}
	public int getWinnerCompetitorId() {
		return winnerCompetitorId;
	}
	public void setWinnerCompetitorId(int winnerCompetitorId) {
		this.winnerCompetitorId = winnerCompetitorId;
	}
	public String getCompetitor1Name() {
		return competitor1Name;
	}
	public void setCompetitor1Name(String competitor1Name) {
		this.competitor1Name = competitor1Name;
	}
	public String getCompetitor2Name() {
		return competitor2Name;
	}
	public void setCompetitor2Name(String competitor2Name) {
		this.competitor2Name = competitor2Name;
	}
}
