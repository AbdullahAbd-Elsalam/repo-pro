package com.conference.web;


import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



 
@WebServlet("/ConferenceRegistrationServlet")
public class ConferenceRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	// define annotation for datasaource
	@Resource(name="jdbc/web_user_tracker")
	private DataSource datasource;
	
	// define userDbUtil
	private UserDBUtil userDBUtil;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		
		try {
			userDBUtil= 	new UserDBUtil(datasource);
			
		}catch(Exception ex) {
			
			throw new ServletException();
			
		}
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
       
        // Validate input (for simplicity, perform basic validation)
        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            // If validation fails, redirect back to the registration page with an error message
            response.sendRedirect("index.html?error=invalid_input");
            return;
        }
        
        try {

    	
            // Store data in the database (using a JDBC connection)
             User users=new User(name, email);
			userDBUtil.addUser(users);
			
			 
		  
			
		} catch (Exception e) {
 			e.printStackTrace();
		}
        
        // send request into jsp page (view)
		RequestDispatcher dispatchr=request.getRequestDispatcher("/confirmation.jsp");
		dispatchr.forward(request, response);
 		 
  
  	}

}
