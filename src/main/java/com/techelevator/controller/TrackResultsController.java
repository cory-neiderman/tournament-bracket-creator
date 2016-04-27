package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.CompetitorDAO;
import com.techelevator.model.Game;
import com.techelevator.model.GameDAO;
import com.techelevator.model.JDBCCompetitorDAO;
import com.techelevator.model.JDBCGameDAO;
import com.techelevator.model.JDBCTournamentDAO;
import com.techelevator.model.Tournament;
import com.techelevator.model.TournamentDAO;
import com.techelevator.model.User;

@Controller
@Transactional
@SessionAttributes({"tournament", "user", "allCompetitors", "teamError", "tournamentId", "gameList", "game"})
public class TrackResultsController {
	
	private TournamentDAO tournamentDAO;
	private CompetitorDAO competitorDAO;
	private GameDAO gameDAO;
	
	@Autowired
	public TrackResultsController(JDBCTournamentDAO tournamentDAO, JDBCCompetitorDAO competitorDAO, JDBCGameDAO gameDAO) {
		this.tournamentDAO = tournamentDAO;
		this.competitorDAO=competitorDAO;
		this.gameDAO = gameDAO;
	}
	
	@RequestMapping(path="/selectTournamentForAddingResults", method=RequestMethod.GET)
	public String displayListOfTournaments(Map<String, Object> model){
		User user = (User)model.get("user");
		List<Tournament> tournamentList = new ArrayList<>();
		tournamentList=tournamentDAO.getListOfTournamentsByUserId(user.getUserId());
		model.put("tournamentList", tournamentList);
		
		return "selectTournamentForAddingResults";
	}
	
	@RequestMapping(path="/selectGameToAddResults", method=RequestMethod.GET)
	public String displayGameToAddResultsForm(Map<String, Object> model,
													@RequestParam(name="tournamentId") int tournamentId){
		Tournament tournament = new Tournament();
		tournament.setTournamentId(tournamentId);
		model.put("tournament", tournament);
		model.put("tournamentId", tournamentId);
		List<Game> gameList = gameDAO.getGameListByTournamentId(tournamentId);
		model.put("gameList", gameList);
		
		User user = (User)model.get("user");
		if (user.getUserRole().equals("host")) {
			return "selectGameToAddResults";
		} else {
			return "homepage";
		}
		
	}
	

	@RequestMapping(path="/recordGameResults", method=RequestMethod.GET)
	public String displayRecordResults(Map<String, Object> model,
								@RequestParam(name="gameId") int gameId){
		
		Game game = gameDAO.getGameByGameId(gameId);
		model.put("game", game);
		
		return "recordGameResults";
	}
	
	@RequestMapping(path="/recordGameScores", method=RequestMethod.POST)
	public String recordScores(Map<String, Object> model,
								@RequestParam(name="competitor1Score") int competitor1Score,
								@RequestParam(name="competitor2Score") int competitor2Score,
								@RequestParam(name="winnerId") int winnerId){
		
		
		Game game = (Game)model.get("game");
		
		gameDAO.recordScore(winnerId, competitor1Score, competitor2Score, game.getGameId());
		
		Tournament tournament = (Tournament)model.get("tournament");
		int teams = tournamentDAO.getMaxTeamsByTournamentId(tournament.getTournamentId());
		
		Game gameRecorded = gameDAO.getGameByGameId(game.getGameId());
		gameDAO.advanceWinner(gameRecorded, teams, tournament.getTournamentId());
		
		
		return "redirect: afterGameRecorded";
	}
	
	
	@RequestMapping(path="/afterGameRecorded", method=RequestMethod.GET)
	public String displayAfterGameRecorded(){
		
		return "afterGameRecorded";
	}
		

	

}
