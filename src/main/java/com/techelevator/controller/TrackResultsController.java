package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.CompetitorDAO;
import com.techelevator.model.GameDAO;
import com.techelevator.model.JDBCCompetitorDAO;
import com.techelevator.model.JDBCGameDAO;
import com.techelevator.model.JDBCTournamentDAO;
import com.techelevator.model.Tournament;
import com.techelevator.model.TournamentDAO;
import com.techelevator.model.User;

@Controller
@Transactional
@SessionAttributes({"tournament", "user", "allCompetitors", "teamError", "tournamentId", "maxTeams"})
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
		tournamentList=tournamentDAO.getListOfTournamentsThatNeedTeamsByUserId(user.getUserId());
		model.put("tournamentList", tournamentList);
		
		return "selectTournamentForAddingResults";
	}

}
