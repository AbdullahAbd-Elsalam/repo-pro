package com.conference.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class UserDBUtil {

	
	// define datasource and pass to constructor 
	private DataSource dataSource;
	
	
	public UserDBUtil(DataSource datasource) {
		
		
		this.dataSource=datasource;
	}
	
// define method to close connecton from db
	private void close(Connection conn, Statement stml, ResultSet rs) {
		// TODO Auto-generated method stub
		
		try {
		
		if(conn!=null) {
			
			conn.close();
		}
		
		if(stml!= null ) {
			
			stml.close();
		}
		
		if(rs!=null) {
			
			
			rs.close();
		}
		
		}catch(Exception exc) {
			exc.printStackTrace();
		}
	}

// add user data into database
	public void addUser(User users) throws SQLException {
 
		Connection conn=null;
		PreparedStatement myStmt = null;
try {
	// get db connection
        conn=dataSource.getConnection();
        

		// create sql for insert
		String sql = "INSERT INTO user (name, email) VALUES (?, ?)";
		
		myStmt = conn.prepareStatement(sql);
		
		// set the param values for the student
		myStmt.setString(1,  users.getName());
		myStmt.setString(2, users.getEmail());
 		// execute sql insert
		myStmt.execute();
	
	
}
finally {
	
	// clean up JDBC objects
	 close(conn, myStmt, null);
	
}
		
	}
	
	
 	
	
}
