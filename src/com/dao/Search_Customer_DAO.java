package com.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;

public class Search_Customer_DAO  {
	Connection conn;
	PreparedStatement stmt;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	public Search_Customer_DAO(){}
	public Search_Customer_DAO(Connection conn) {
		this.conn=conn;
	}
		
	public List<Customer> getAll() throws SQLException {
		stmt = conn.prepareStatement("SELECT CUST_FIRST_NAME,CUSTOMER_ID,DATE_OF_BIRTH,PREFERRED_ACC_1,EMAIL_ID,PAN,MOBILE_NUM FROM CUSTOMER order by CUSTOMER_ID asc");
		return search();
	}
	public List<Customer> byName(String name) throws SQLException {
		System.out.println("inside byname");
		stmt = conn.prepareStatement("SELECT CUST_FIRST_NAME,CUSTOMER_ID,DATE_OF_BIRTH,PREFERRED_ACC_1,EMAIL_ID,PAN,MOBILE_NUM FROM CUSTOMER WHERE CUST_FIRST_NAME = any (?,?) order by CUSTOMER_ID asc");
		stmt.setString(1,name.toUpperCase());
		stmt.setString(2,name.toLowerCase());
		System.out.println("after query");
		return search();
	}
	public List<Customer> byCustomer_id(String customer_id) throws SQLException {
		stmt = conn.prepareStatement("SELECT CUST_FIRST_NAME,CUSTOMER_ID,DATE_OF_BIRTH,PREFERRED_ACC_1,EMAIL_ID,PAN,MOBILE_NUM FROM CUSTOMER WHERE CUSTOMER_ID=? order by CUSTOMER_ID asc");
		stmt.setString(1,customer_id);
		return search();
	}
	public List<Customer> byDOB(String dob) throws SQLException, ParseException {
		stmt = conn.prepareStatement("SELECT CUST_FIRST_NAME,CUSTOMER_ID,DATE_OF_BIRTH,PREFERRED_ACC_1,EMAIL_ID,PAN,MOBILE_NUM FROM CUSTOMER WHERE DATE_OF_BIRTH = to_date(?,'dd-MM-yyyy') order by CUSTOMER_ID asc");
		//Date d=(Date)sdf.parse(dob);
		stmt.setString(1,dob);
//	stmt.setString(2,dob.toLowerCase());
		return search();
	}
	public List<Customer> byAccount_number(String account_number) throws SQLException {
		stmt = conn.prepareStatement("SELECT CUST_FIRST_NAME,CUSTOMER_ID,DATE_OF_BIRTH,PREFERRED_ACC_1,EMAIL_ID,PAN,MOBILE_NUM FROM CUSTOMER WHERE PREFERRED_ACC_1=? order by CUSTOMER_ID asc");
		stmt.setString(1,account_number);
		return search();
	}
	public List<Customer> byEmail_id(String email_id) throws SQLException {
		stmt = conn.prepareStatement("SELECT CUST_FIRST_NAME,CUSTOMER_ID,DATE_OF_BIRTH,PREFERRED_ACC_1,EMAIL_ID,PAN,MOBILE_NUM FROM CUSTOMER WHERE EMAIL_ID = any (?,?) order by CUSTOMER_ID asc");
		stmt.setString(1,email_id.toUpperCase());
		stmt.setString(2,email_id.toLowerCase());
		return search();
	}
	public List<Customer> byPan_number(String Pan_number) throws SQLException {
		stmt = conn.prepareStatement("SELECT CUST_FIRST_NAME,CUSTOMER_ID,DATE_OF_BIRTH,PREFERRED_ACC_!,EMAIL_ID,PAN,MOBILE_NUM FROM CUSTOMER WHERE PAN = any (?,?) order by CUSTOMER_ID asc");
		stmt.setString(1,Pan_number.toUpperCase());
		stmt.setString(2,Pan_number.toLowerCase());
		return search();
	}
	public  List<Customer> byContact_number(String contact_number) throws SQLException {
		stmt = conn.prepareStatement("SELECT CUST_FIRST_NAME,CUSTOMER_ID,DATE_OF_BIRTH,PREFERRED_ACC_1,EMAIL_ID,PAN,MOBILE_NUM FROM CUSTOMER WHERE MOBILE_NUM=? order by CUSTOMER_ID asc");
		stmt.setString(1,contact_number);
		return search();
	}
	@SuppressWarnings("unused")
	public ArrayList<Customer> search() throws SQLException {
		System.out.println("inside search");
		ResultSet rs = stmt.executeQuery();
		ArrayList<Customer> lc=new ArrayList<Customer>();
		while(rs.next()) {
		System.out.println("inside while");
		Customer c=new Customer();
		c.setCust_first_name(rs.getString(1).toUpperCase());
		System.out.println(rs.getString(1));
		c.setCustomer_id(rs.getString(2));
		System.out.println(rs.getString(2));
		c.setDate_of_birth(rs.getString(3));
		System.out.println(rs.getString(3));
		c.setPreferred_acc_1(rs.getString(4));
		System.out.println(rs.getString(4));
		c.setEmail_id(rs.getString(5).toUpperCase());
		System.out.println(rs.getString(5));
		c.setPan(rs.getString(6).toUpperCase());
		System.out.println(rs.getString(6));
		c.setMobile_num(rs.getString(7));
		System.out.println(rs.getString(7));
		lc.add(c);
		System.out.println("after added to lc");
		
		}
		if(lc!=null)
	        return lc;
		else
			return null;
	
	}
	
}
