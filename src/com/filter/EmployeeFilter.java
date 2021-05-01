package com.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.dao.Employee_Login_DAO;
import com.model.Employee;

/**
 * Servlet Filter implementation class EmployeeFilter
 */
@WebFilter(urlPatterns= {"/Employee_Servlet"},servletNames = { "com.controller.Employee_Servlet" })
public class EmployeeFilter implements Filter {

 
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			ServletContext context = request.getServletContext();
			
			String username = request.getParameter("username");
			System.out.println("HTML= "+username);
			String password = request.getParameter("password");
			Employee_Login_DAO obj = new Employee_Login_DAO();
			Connection conn = (Connection) context.getAttribute("connection");
			Employee e = obj.getEmployee(conn, username, password);
			if(e==null) {
				System.out.println("null");
				request.getRequestDispatcher("Customer_One_System_index.html").include(request, response);
				pw.println("<h3 align='center' style=color:red> Incorrect username or password</h3>");
				
			}
			else if(e.getUsername().equals(username) && e.getPassword().equals(password)) {
				
				System.out.println("valid" +e.getUsername()+" "+ e.getPassword());
				chain.doFilter(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
