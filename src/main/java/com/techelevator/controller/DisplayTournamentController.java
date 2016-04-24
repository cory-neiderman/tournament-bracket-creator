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

import com.techelevator.model.Competitor;
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
@SessionAttributes("tournamentList")
public class DisplayTournamentController {
	
	private TournamentDAO tournamentDAO;
	private CompetitorDAO competitorDAO;
	private GameDAO gameDAO;
	
	@Autowired
	public DisplayTournamentController(JDBCTournamentDAO tournamentDAO, JDBCCompetitorDAO competitorDAO, JDBCGameDAO gameDAO) {
		this.tournamentDAO = tournamentDAO;
		this.competitorDAO=competitorDAO;
		this.gameDAO=gameDAO;
	}
	
	@RequestMapping(path="/displayAllTournaments", method=RequestMethod.GET)
	public String displayListOfAllTournaments(Map<String, Object> model){
		List<Tournament> tournamentList = new ArrayList<>();
		tournamentList=tournamentDAO.getListOfAllTournaments();
		model.put("tournamentList", tournamentList);
		
		return "displayAllTournaments";
	}
	@RequestMapping(path="/displayTournamentBracket", method=RequestMethod.GET)
	public String displayTournamentById(Map<String, Object> model,
										@RequestParam(name="tournamentId") int tournamentId){
		
		Tournament tournament = tournamentDAO.getTournamentById(tournamentId);
		model.put("tournament", tournament);
		
		List<Game> gameList = new ArrayList<>();
		//gameList = gameDAO.getGameListByTournamentId(tournamentId);
		model.put("gameList", gameList);
		
		return "displayTournamentBracket";
	}
}