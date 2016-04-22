package com.techelevator.model;

import java.time.LocalDate;

public class Game {
	
	private int game;
	private int tournamentId;
	private int competitor1;
	private int competitor2;
	private int competitor1Score;
	private int competitor2Score;
	private LocalDate date;
	public int getGame() {
		return game;
	}
	public void setGame(int game) {
		this.game = game;
	}
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
}
