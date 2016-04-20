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
import com.techelevator.model.JDBCCompetitorDAO;
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
	
	@Autowired
	public AddTeamController(JDBCTournamentDAO tournamentDAO, JDBCCompetitorDAO competitorDAO) {
		this.tournamentDAO = tournamentDAO;
		this.competitorDAO=competitorDAO;
	}
	
	@RequestMapping(path="/selectTournamentForAddingCompetitors", method=RequestMethod.GET)
	public String displayListOfTournaments(Map<String, Object> model){
		User user = (User)model.get("user");
		List<Tournament> tournamentList = new ArrayList<>();
		tournamentList=tournamentDAO.getListOfTournamentsByUserId(user.getUserId());
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
		competitorDAO.enterCompetitorsIntoCompetitiorTournament(allCompetitors, tournament.getTournamentId());
		model.put("allCompetitors", allCompetitors);
		
		return "redirect:/enterTeamsPage";
	}
	

	@RequestMapping(path="/enterTeamsPage", method=RequestMethod.GET)
	public String displayTeams(Map<String, Object> model){
		
		
		
		return "displayTeams";
	}
	

}
