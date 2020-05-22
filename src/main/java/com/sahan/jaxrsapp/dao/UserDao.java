package com.sahan.jaxrsapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sahan.jaxrsapp.model.User;

public class UserDao {
	
	public static UserDao instanceDao = new UserDao();
	
	public static UserDao getInstance() {
		return instanceDao;
	}
	
	private UserDao() {
		
	}
	
	public User LoginChecker(String email, String password) {
		User user = new User();
		
		try {
			
			Connection connection = Configs.getDbConnection();
			String sql = "SELECT * FROM tbl_user WHERE email=? AND password=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setRole(USER_ROLES.valueOf(rs.getString("role")));
			}
 			connection.close();
 			
 			return user;
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return user;
	}
	
	
	public List<User> getAll() {
		List<User> userList = new ArrayList<User>();
		
		try {
			
			Connection connection = Configs.getDbConnection();
			String sql = "SELECT * FROM tbl_user";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setRole(USER_ROLES.valueOf(rs.getString("role")));
				
				userList.add(user);
			}
 			connection.close();
 			
 			return userList;
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return userList;
	}

}
