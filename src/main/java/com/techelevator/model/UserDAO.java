package com.techelevator.model;

public interface UserDAO {
	
	public void saveUser(String userName, String password, String userRole);

	public User getUserIdByNameAndPassword(String username, String password);

}
