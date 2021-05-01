package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.model.Account;

public class Deduplication_DAO {
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public List<Account> getAccounts(Connection conn) throws SQLException {
		List<Account> list=new ArrayList();
		
		
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select account_number,first_name,mid_name,last_name,address,city,pin,mobile_num,"
				+ "date_of_birth,status,pan,occupation,salary,email_id,aadhar,state,country,open_date,gender "
				+ "from account where customer_id is null order by pan asc");
		while(rs.next()) {
			Account ac=new Account();
			//Account a1=new Account(rs.getString(1).toLowerCase(),rs.getString(2).toLowerCase(), null, rs.getString(3).toLowerCase(),rs.getString(4).toLowerCase(),rs.getString(5).toLowerCase(), null, rs.getString(6).toLowerCase(),rs.getString(7),rs.getString(8), null, null, null, null, null, null, null, null, null, rs.getDate(9), null, rs.getString(10).toLowerCase(),rs.getString(11).toLowerCase(), null, null);
			ac.setAccount_number(rs.getString(1).toLowerCase());
			ac.setFirst_name(rs.getString(2).toLowerCase());
			System.out.println("first="+ac.getFirst_name());
			ac.setMid_name(rs.getString(3));
			System.out.println("mid="+ac.getMid_name());
			ac.setLast_name(rs.getString(4).toLowerCase());
			ac.setAddress(rs.getString(5).toLowerCase());
			ac.setCity(rs.getString(6).toLowerCase());
			ac.setPin(rs.getString(7));
			ac.setMobile_num(rs.getString(8));
			ac.setDate_of_birth(rs.getDate(9));
			ac.setStatus(rs.getString(10).toLowerCase());
			ac.setPan(rs.getString(11).toLowerCase());
			ac.setOccupation(rs.getString(12).toLowerCase());
			ac.setSalary(rs.getInt(13));
			ac.setEmail_id(rs.getString(14).toLowerCase());
			ac.setAadhar(rs.getString(15).toLowerCase());
			ac.setState(rs.getString(16).toLowerCase());
			ac.setCountry(rs.getString(17).toLowerCase());
			ac.setOpen_date(rs.getDate(18));
			ac.setGender(rs.getString(19));
			list.add(ac);
			//list.add(a1);
			
		}
		if(list!=null)
		    return list;
		else
			return null;
		
	}
//	public ArrayList<Account> getAcc_Customer(Connection conn,String s[]) throws SQLException{
//		ArrayList ala=new ArrayList();
//	        String queryString = "Select account_number,first_name,mid_name,last_name,"
//	        		+ "date_of_birth,mobile_num,email_id,address,pin,pan,aadhar,city,"
//	        		+ "state,country,occupation,salary"
//	        		+ " from account where column_name in ";
//
//	        StringBuilder sb = new StringBuilder();
//	        sb.append(" (");
//	        for (int i = 0; i < s.length ; i++) {
//	            sb.append("?");
//	            if (s.length > i + 1) {
//	                sb.append(",");
//	            }
//	        }
//	        sb.append(")");
//
//	        PreparedStatement pst = conn.prepareStatement(queryString + sb);
//	        for (int i = 1; i < s.length + 1; i++) {
//	            pst.setString(i, s[i]);
//	        }
//	        ResultSet rs=pst.executeQuery();
//	        while(rs.next()) {
//	        	Account ac=new Account();
//	        	ac.setAccount_number(rs.getString(1).toLowerCase());
//				ac.setFirst_name(rs.getString(2).toLowerCase());
//				ac.setMid_name(rs.getString(3));
//				ac.setLast_name(rs.getString(4).toLowerCase());
//				ac.setAddress(rs.getString(5).toLowerCase());
//				ac.setCity(rs.getString(6).toLowerCase());
//				ac.setPin(rs.getString(7));
//				ac.setMobile_num(rs.getString(8));
//				ac.setDate_of_birth(rs.getDate(9));
//				
//				ac.setPan(rs.getString(11).toLowerCase());
//				ala.add(ac);
//	        }
//	        
//	        if(ala!=null)
//			    return ala;
//			else
//				return null;
//	}
	public void insertCustomer(Connection conn,ArrayList<Account> al,Date rsd) throws SQLException {
		SimpleDateFormat sdformat = new SimpleDateFormat("dd-MMM-yyyy");
		PreparedStatement ps = null;
		String accn="";
		Integer cid=0;
		Iterator<Account> it=al.iterator();
		while(it.hasNext()) {
			Account ac=it.next();
			if(ac.getOpen_date().compareTo(rsd)==0) {
			ps=conn.prepareStatement("INSERT INTO CUSTOMER(CUST_FIRST_NAME,CUST_MID_NAME,CUST_LAST_NAME,DATE_OF_BIRTH," + 
					"MOBILE_NUM,EMAIL_ID,ADDRESS,PIN,PAN,AADHAR,CITY,STATE,COUNTRY,OCCUPATION," + 
					"SALARY,GENDER,RELATIONSHIP_START_DATE,CUST_USER_NAME,CUST_PASSWORD,PREFERRED_ACC_1) " + 
					"VALUES(?,?,?,?,?,?,?," + 
					"?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, ac.getFirst_name());
			ps.setString(2, ac.getMid_name());
			ps.setString(3, ac.getLast_name());
			ps.setDate(4, ac.getDate_of_birth());
			System.out.println("dob="+ sdformat.format(ac.getDate_of_birth()));
			ps.setString(5, ac.getMobile_num());
			ps.setString(6, ac.getEmail_id());
			ps.setString(7, ac.getAddress());
			ps.setString(8, ac.getPin());
			ps.setString(9, ac.getPan());
			ps.setString(10, ac.getAadhar());
			ps.setString(11, ac.getCity());
			ps.setString(12, ac.getState());
			ps.setString(13, ac.getCountry());
			ps.setString(14, ac.getOccupation());
			ps.setInt(15, ac.getSalary());
			ps.setString(16, ac.getGender());
			ps.setDate(17,ac.getOpen_date());
			System.out.println("open_date="+ sdformat.format(ac.getOpen_date()));
			ps.setString(18, ac.getAccount_number());
			ps.setString(19, ac.getMobile_num());
			ps.setString(20, ac.getAccount_number());
			accn=ac.getAccount_number();
			ps.execute();
			break;
			}
		}
		ps=conn.prepareStatement("select customer_id from customer where preferred_acc_1=?");
		ps.setString(1, accn);
		System.out.println("selected");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			cid=rs.getInt(1);
		}
		Iterator<Account> itu=al.iterator();
		while(itu.hasNext()) {
			Account ac=itu.next();
			ps=conn.prepareStatement("update account set customer_id=? where account_number=?");
			ps.setInt(1, cid);
			ps.setString(2, ac.getAccount_number());
			ps.execute();
			System.out.println("updated");
		}
		
	}

}

