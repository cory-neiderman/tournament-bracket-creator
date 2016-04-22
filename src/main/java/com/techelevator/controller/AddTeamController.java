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
import com.techelevator.model.GameDAO;
import com.techelevator.model.JDBCCompetitorDAO;
import com.techelevator.model.JDBCGameDAO;
import com.techelevator.model.JDBCTournamentDAO;
import com.techelevator.model.Tournament;
import com.techelevator.model.TournamentDAO;
import com.techelevator.model.User;

@Controller
@Transactional
@SessionAttributes({"tournament", "user", "allCompetitors"})
public class AddTeamController {
	
	private TournamentDAO tournamentDAO;
	private CompetitorDAO competitorDAO;
	private GameDAO gameDAO;
	
	@Autowired
	public AddTeamController(JDBCTournamentDAO tournamentDAO, JDBCCompetitorDAO competitorDAO, JDBCGameDAO gameDAO) {
		this.tournamentDAO = tournamentDAO;
		this.competitorDAO=competitorDAO;
		this.gameDAO = gameDAO;
	}
	
	@RequestMapping(path="/selectTournamentForAddingCompetitors", method=RequestMethod.GET)
	public String displayListOfTournaments(Map<String, Object> model){
		User user = (User)model.get("user");
		List<Tournament> tournamentList = new ArrayList<>();
		tournamentList=tournamentDAO.getListOfTournamentsThatNeedTeamsByUserId(user.getUserId());
		model.put("tournamentList", tournamentList);
		
		return "selectTournamentForAddingCompetitors";
	}
	
	@RequestMapping(path="/addCompetitorsToTournament", method=RequestMethod.GET)
	public String displayAddCompetitorsForm(Map<String, Object> model,
													@RequestParam(name="tournamentId") int tournamentId){
		Tournament tournament = new Tournament();
		tournament.setTournamentId(tournamentId);
		model.put("tournament", tournament);
		int maxTeams = tournamentDAO.getMaxTeamsByTournamentId(tournamentId);
		model.put("maxTeams", maxTeams);
		
		return "addCompetitorsToTournament";
	}
	
	@RequestMapping(path="/addTeams", method=RequestMethod.POST)
	public String enterTeams(Map<String, Object> model,
								@RequestParam(name="competitorName") String competitorName){
		
		String[] allCompetitors = competitorName.split(",");
		competitorDAO.enterCompetitors(allCompetitors);
		Tournament tournament = (Tournament)model.get("tournament");
		competitorDAO.enterCompetitorsIntoCompetitorTournament(allCompetitors, tournament.getTournamentId());
		gameDAO.createGames(allCompetitors);
		model.put("allCompetitors", allCompetitors);
		
		return "redirect:/afterEnterTeams";
	}
	

	@RequestMapping(path="/afterEnterTeams", method=RequestMethod.GET)
	public String displayTeams(Map<String, Object> model){
		
		
		
		return "homepage";
	}
	

}
