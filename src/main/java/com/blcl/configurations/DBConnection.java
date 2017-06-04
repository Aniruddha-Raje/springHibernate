package com.blcl.configurations;

import java.sql.Connection;
import java.sql.DriverManager;

import com.blcl.utils.Constants;

public class DBConnection {
	
	public Connection makeConnection() throws Exception{
		Constants constants = Constants.getInstance();
		Connection conn = null;
		
		Class.forName(constants.getDriverClassName());
		conn = DriverManager.getConnection(constants.getUrl(),constants.getUserName(),constants.getPassword());
		
		return conn;
	}
	
}
