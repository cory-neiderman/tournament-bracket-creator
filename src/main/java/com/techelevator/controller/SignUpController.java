package com.techelevator.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCUserDAO;



@Controller

public class SignUpController {
	
	JDBCUserDAO userDAO;
	
	@Autowired
	public SignUpController(JDBCUserDAO userDAO){
		this.userDAO = userDAO;
	}	
	
	@RequestMapping(path="/signUp", method=RequestMethod.GET)
	public String displaySignUpPage(){
		
		return "signUp";
	}
	
	@RequestMapping(path="newUserSignUp", method=RequestMethod.POST)
	public String createNewUser(Map<String, Object> model,
								@RequestParam(name="userName") String userName,
								@RequestParam(name="password") String password,
								@RequestParam(name="role") String role){
		
		
		userDAO.saveUser(userName, password, role);
		//model.put("user", userDAO.getUserIdByNameAndPassword(userName, password));
		
		return "redirect:/";
	}
}
