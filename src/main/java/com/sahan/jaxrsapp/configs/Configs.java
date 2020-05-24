package com.sahan.jaxrsapp.configs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configs {
	
	public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
		
		String connURL = "jdbc:mysql://us-cdbr-east-06.cleardb.net:3306/heroku_677cfadb2807d1c";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(connURL, "b388ac2ebe8984", "0668a5ce");
		return conn;
	}

}
