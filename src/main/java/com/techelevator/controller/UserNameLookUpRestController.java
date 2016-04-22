package com.techelevator.controller;

import java.util.List;
import java.util.Map;

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
		public boolean searchForUsername(@PathVariable String userName){
			
			return userDAO.searchForUsername(userName);
		}
	}

