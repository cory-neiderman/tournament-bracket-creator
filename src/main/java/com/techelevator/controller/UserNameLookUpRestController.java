package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.JDBCUserDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@RestController
@Transactional
@SessionAttributes({"task", "user"})
public class UserNameLookUpRestController {
	
	
		
		private UserDAO userDAO;
		
		@Autowired
		public UserNameLookUpRestController(JDBCUserDAO userDAO) {
			this.userDAO = userDAO;
		}
		
		@RequestMapping(path="/signUp/{userName}", method=RequestMethod.GET)
		public List<String> searchForUsername(@PathVariable String userName){
			
			List<String> result = new ArrayList<>();
			if(userDAO.searchForUsername(userName)){
				result.add("Userame is taken");
				return result;
			}
			else{
				result.add("Username is available");
				return result;
			}
		}
	}

