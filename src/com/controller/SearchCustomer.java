package com.controller;
import com.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Customer;
import com.model.Employee;


@WebServlet("/SearchCustomer")
public class SearchCustomer extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		ServletContext context = request.getServletContext();
		Connection conn = (Connection) context.getAttribute("connection");
		String name=request.getParameter("name");
		String customer_id=request.getParameter("customer_id");
		String dob=request.getParameter("dob");
		String account_number=request.getParameter("account_number");
		String email_id=request.getParameter("email_id");
		String pan_number=request.getParameter("pan_number");
		String contact_number=request.getParameter("contact_number");
		Search_Customer_DAO scd=new Search_Customer_DAO(conn);
		System.out.println("in servlet");
		
		List<Customer> lc=new ArrayList();
		if(name.equals("") && customer_id.equals("") &&
		  dob.equals("")&&account_number.equals("")   && 
		  email_id.equals("") && pan_number.equals("") && 
		   contact_number.equals(""))
			
				{
					try {
						System.out.println("in try ");
						lc=scd.getAll();
					} catch (SQLException e) {
						System.out.println("in catch");
						e.printStackTrace();
					}
		}
		
		else if(customer_id!="") {
				try {
					System.out.println("inside cid try");
					lc=scd.byCustomer_id(customer_id);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		else if(name!="") {	
			
			try {
				
				System.out.println("inside try name"+name);
				lc=scd.byName(name);
			} catch (SQLException e) {
				System.out.println("inside catch name");
				e.printStackTrace();
			}		
	}
		else if(dob!="") {
				try {
					lc=scd.byDOB(dob);
				} catch (SQLException e) {
					
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else if(account_number!="") {
				try {
					lc=scd.byAccount_number(account_number);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		else if(email_id!="") {
				try {
					lc=scd.byEmail_id(email_id);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		else if(pan_number!="") {
				try {
					lc=scd.byPan_number(pan_number);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
		else if(contact_number!="") {
				try {
					lc=scd.byContact_number(contact_number);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		//context = getServletContext();
		HttpSession session = request.getSession();
		session.setAttribute("slist",lc);
		System.out.println("out");
		request.getRequestDispatcher("List_Of_Customers.jsp").forward(request, response);

	}

}
