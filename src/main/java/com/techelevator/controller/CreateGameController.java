/*package com.techelevator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCTournamentDAO;
import com.techelevator.model.TournamentDAO;

@Controller
@Transactional
@SessionAttributes("game")
public class CreateGameController {
	
	private GameDAO gameDAO;
	
	@Autowired
	public CreateGameController(JDBCGameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}
	
	@RequestMapping(path="/scheduleMatches")
	public String displayCreateTournamentPage(){
		return "scheduleMatches";
	}
	
	
	
	

}*/
