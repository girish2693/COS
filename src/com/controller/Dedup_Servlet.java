package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Deduplication_DAO;
import com.model.Account;

/**
 * Servlet implementation class Dedup_Servlet
 */
@WebServlet("/Dedup_Servlet")
public class Dedup_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String[] cb = request.getParameterValues("cb");
		String[] pan = new String[cb.length];
		String[] dob = new String[cb.length];
		Date[] op= new Date[cb.length];
		Date rsd = null;
		boolean flag=false;
		
		int p = 0, d = 0,o=0;
		Deduplication_DAO ddao = new Deduplication_DAO();
		ServletContext context = request.getServletContext();
		Connection conn = (Connection) context.getAttribute("connection");
		ArrayList<Account> list =new ArrayList<Account>();
		ArrayList<Account> cust_Insert=new ArrayList<Account>();
		try {
			list = (ArrayList<Account>) ddao.getAccounts(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Arrays.toString(cb));
		// pw.println(Arrays.toString(cb));
		// Iterator<Account> it=list.iterator();

		System.out.println("validation begin for pan and dob::");
		
		for (String c : cb) {
			for (Account ac : list) {
				// Account ac=it.next();
				if (c.equals(ac.getAccount_number())) {
					System.out.println(ac.getAccount_number());
					pan[p++] = ac.getPan();
					dob[d++] = ac.getDate_of_birth().toString();
					op[o++]= (Date) ac.getOpen_date();
					cust_Insert.add(ac);
					break;
				}
			}
		}
		int i, j;
		for (i = 0, j = 0; i < pan.length - 1 && j < dob.length - 1; i++, j++) {
			if (!pan[i].equals(pan[i + 1]) && !dob[j].equals(dob[j + 1])) {
				pw.println(
						"<script type=\"text/javascript\">alert('Pan or DOB are not matching..');</script>");
				request.getRequestDispatcher("De-Duplication.jsp").include(request, response);
				
				flag=false;
				break;
			}
			else {
				flag=true;
			}
		}
		for(int z=0;z<op.length-1;z++) {
			for(int y=1;y<op.length;y++)
			if(op[z].compareTo(op[y])<0 || op[z].compareTo(op[y])==0) {
				rsd=op[z];
				System.out.println("if = date1= "+op[z]+" ,date2= "+op[y]+" min= "+rsd);
			}
			else {
				rsd=op[y];
				System.out.println("else = date1= "+op[z]+" ,date2= "+op[y]+" min= "+rsd);
			}
		}
		
		// insert into customer nd update for account
		if(flag==true) {
		try {
			ddao.insertCustomer(conn, cust_Insert,rsd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<script type=\"text/javascript\">alert('De-Duplication is Success..');</script>");
	request.getRequestDispatcher("De-Duplication.jsp").include(request, response);
	
		}
	   }
	}


