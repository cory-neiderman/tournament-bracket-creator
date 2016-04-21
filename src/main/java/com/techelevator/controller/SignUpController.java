package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCUserDAO;



@Controller
@Transactional
@SessionAttributes("signUpError")
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
		
		if(!userDAO.searchForUsername(userName)){
			userDAO.saveUser(userName, password, role);
			return "redirect:/";
			
		}
		else{
			//model.put("signUpError", "Username is already taken");
			return "redirect:/signUp";
		}
		
		
	}
	@RequestMapping(path="/signUp/{userName}", method=RequestMethod.GET)
	public boolean searchForUsername(@PathVariable String userName){
		
		return userDAO.searchForUsername(userName);
	}
	
	
}
