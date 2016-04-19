package com.techelevator.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCUserDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes("user")
public class LoginController{
	
	UserDAO userDAO;
	
	@Autowired
	public LoginController(JDBCUserDAO userDAO){
		this.userDAO = userDAO;
	}	
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String displayLoginPage(){
		return "logIn";
	}
	
	@RequestMapping(path="login", method=RequestMethod.POST)
    public String lookUpUser(Map<String, Object> model,
                                @RequestParam(name="username") String username,
                                @RequestParam(name="password") String password,
                                HttpSession session){
        
        if(userDAO.getUserIdByName(username) != null && userDAO.searchForUsernameAndPassword(username, password) == true){
        	session.invalidate();
            model.put("user", userDAO.getUserIdByName(username));
            return "redirect:/homepage";
        }
        else{
            return "redirect:/";
        }
    }
	
	@RequestMapping(path="/tournamentHost", method=RequestMethod.GET)
	public String displayTournamentHostPage(User user, HttpSession session) {
		session.getAttribute("user");
		if (user.getUserRole().equals("host")) {
			return "tournamentHost";
		} else {
			return "homepage";
		}
		
	}

	@RequestMapping(path="/homepage", method=RequestMethod.GET)
	public String displayHomepage(Map<String, Object> model) {
		return "homepage";
	}
	
	
}