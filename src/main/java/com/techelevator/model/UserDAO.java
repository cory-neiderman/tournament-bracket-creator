package com.techelevator.model;

public interface UserDAO {
	
	public void saveUser(String userName, String password, String userRole);

	public User getUserIdByName(String username);

	boolean searchForUsernameAndPassword(String username, String password);

}
