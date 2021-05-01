package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.connection.DBConnection;
import com.model.Employee;

public class Employee_Login_DAO {
	public Employee getEmployee(Connection conn, String username, String password) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE USERNAME=? AND PASSWORD=?");
		stmt.setString(1, username.toUpperCase());
		stmt.setString(2, password.toUpperCase());
		ResultSet rs = stmt.executeQuery();
		System.out.println("while");
		while(rs.next()) {
			Employee e = new Employee();
			e.setEmp_id(rs.getInt(1));
			e.setEmp_first_name(rs.getString(2));
			e.setEmp_mid_name(rs.getString(3));
			e.setEmp_last_name(rs.getString(4));
			e.setDesignation(rs.getString(5));
			e.setBranch_ifsc(rs.getString(6));
			e.setUsername(rs.getString(7).toLowerCase());
			System.out.println(e.getUsername());
			e.setPassword(rs.getString(8).toLowerCase());
			e.setEmp_role(rs.getString(9));
			System.out.println("");
			return e;
			
		}
		return null;
				
	}
}
