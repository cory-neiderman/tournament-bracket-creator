package com.techelevator.model;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techelevator.security.PasswordHasher;

@Component
public class JDBCUserDAO implements UserDAO{
	
	private JdbcTemplate jdbcTemplate;
	private PasswordHasher passwordHasher;

	@Autowired
	public JDBCUserDAO(DataSource dataSource, PasswordHasher passwordHasher) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.passwordHasher = passwordHasher;
	}
	

	@Override
	public void saveUser(String userName, String password, String userRole) {
		
		byte[] salt = passwordHasher.generateRandomSalt();
		String saltString = new String(Base64.encode(salt));
		String passwordHash=passwordHasher.computeHash(password, salt);
		
		
		jdbcTemplate.update("INSERT INTO app_user(user_name, password, salt, user_role) VALUES (?,?,?,?)", userName, passwordHash, saltString, userRole);
		
	}
	

}