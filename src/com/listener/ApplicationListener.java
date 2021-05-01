package com.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.connection.DBConnection;


@WebListener
public class ApplicationListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0)  { 
        // TODO Auto-generated method stub
   	
   	ServletContext context = arg0.getServletContext();
   	Connection conn = (Connection)context.getAttribute("connection");
   	try {
			conn.close();
		} catch (SQLException e) {
			// replace this with a redirect to the error page
			e.printStackTrace();
		}
   }

	
   public void contextInitialized(ServletContextEvent arg0)  { 
        // TODO Auto-generated method stub
   	
   	ServletContext context = arg0.getServletContext();
   	try {
   		
			Connection conn = DBConnection.getConnection();
			context.setAttribute("connection", conn);
			
		} catch (ClassNotFoundException | SQLException e) {
			// replace this with a redirect to the error page
			e.printStackTrace();
			
		}
   }
	
}
