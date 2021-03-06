package com.techelevator.model;

import java.time.LocalDate;

public class Tournament {
	
	private int tournamentId;
	private int userId;
	private String tournamentName;
	private int championId;
	private LocalDate startDate;
	private LocalDate endDate;
	private int minTeams;
	private int maxTeams;
	private String sport;
	private int getNumberOfRounds;
	
	public int getNumberOfRounds(){
		int count=0;
		int n = maxTeams;
		while(n>1){
			n=n/2;
			count=count+1;
		}
		return count;
	}
	
	public int getTournamentId() {
		return tournamentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
	public String getTournamentName() {
		return tournamentName;
	}
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
	public int getChampionId() {
		return championId;
	}
	public void setChampionId(int championId) {
		this.championId = championId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public int getMinTeams() {
		return minTeams;
	}
	public void setMinTeams(int minTeams) {
		this.minTeams = minTeams;
	}
	public int getMaxTeams() {
		return maxTeams;
	}
	public void setMaxTeams(int maxTeams) {
		this.maxTeams = maxTeams;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getStartDateAsString() {
		return String.valueOf(startDate);	
	}
	
	public String getEndDateAsString() {
		return String.valueOf(endDate);	
	}

	
	

}