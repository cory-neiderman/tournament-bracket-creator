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
public class JDBCUserDAO implements UserDAO {

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
		String passwordHash = passwordHasher.computeHash(password, salt);

		jdbcTemplate.update("INSERT INTO app_user(user_name, password, salt, user_role) VALUES (?,?,?,?)",userName,
				passwordHash, saltString, userRole);

	}
	@Override
	public boolean searchForUsernameAndPassword(String username, String password) {
		String sqlSearchForUser = "SELECT * "+
							      "FROM app_user "+
							      "WHERE UPPER(user_name) = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, username.toUpperCase());
		if (results.next()) {
			String storedSalt = results.getString("salt");
			String storedPassword = results.getString("password");
			String passwordHash = passwordHasher.computeHash(password, Base64.decode(storedSalt));
			return storedPassword.equals(passwordHash);
		} else {
			return false;
		}
		
		
	}
	
	public boolean searchForUsername(String username) {
		String sqlSearchForUser = "SELECT * "+
							      "FROM app_user "+
							      "WHERE UPPER(user_name) = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser, username.toUpperCase());
		if (results.next()) {
			return true;
		} else {
			return false;
		}
		
		
	}

	@Override
	public User getUserIdByName(String username) {

		String sqlQueryForId = "SELECT app_user_id, user_role FROM app_user WHERE user_name=?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlQueryForId, username);

		if (results.next()) {

			User user = new User();
			user.setUserName(username);
			user.setUserId(results.getInt("app_user_id"));
			user.setUserRole(results.getString("user_role"));

			return user;
		} else
			return null;

	}

}

