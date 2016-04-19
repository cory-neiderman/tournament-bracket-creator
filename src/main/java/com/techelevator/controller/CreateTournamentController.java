package com.techelevator.controller;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCTournamentDAO;
import com.techelevator.model.Tournament;
import com.techelevator.model.TournamentDAO;
import com.techelevator.model.User;



@Controller
@Transactional
@SessionAttributes({"tournament", "user"})
public class CreateTournamentController {
	
	private TournamentDAO tournamentDAO;
	
	@Autowired
	public CreateTournamentController(JDBCTournamentDAO tournamentDAO) {
		this.tournamentDAO = tournamentDAO;
		
	}
	@RequestMapping(path="/createTournament")
	public String displayCreateTournamentPage(){
		return "createTournament";
	}
	
	@RequestMapping(path="/newTournament", method=RequestMethod.GET)
	public String createTournament(Map<String, Object> model,
										@RequestParam (name="tournamentName") String tournamentName,
										@RequestParam (name="sport") String sport,
										@RequestParam (name="numberOfTeams") String numberOfTeams,
										@RequestParam (name="startDate") String startDate,
										@RequestParam (name="endDate") String endDate,
										HttpSession session){
		
			User user = (User)model.get("user");
			Tournament tournament = new Tournament();
				tournament.setUserId(user.getUserId());
				tournament.setTournamentName(tournamentName);
				tournament.setSport(sport);
				tournament.setMaxTeams(Integer.parseInt(numberOfTeams));
				tournament.setStartDate(LocalDate.parse(startDate));
				tournament.setEndDate(LocalDate.parse(endDate));
				
										
			model.put("tournament", tournament);
			session.getAttribute("user");
			if (user.getUserRole().equals("host")) {
				return "verifyTournament";
			} else {
				return "homepage";
			}
			
	}
	
	@RequestMapping(path="/confirmTournament", method=RequestMethod.POST)
	public String confirmTournament(Map<String, Object> model){
		
		
			Tournament tournament = (Tournament)model.get("tournament");
			tournamentDAO.createTournament(tournament);
		
			return "redirect:/tournamentConfirmation";
	}
	
	@RequestMapping(path="/tournamentConfirmation", method=RequestMethod.GET)
	public String returnToHomePage(){
		return "homepage";
		
	}
	
	
}