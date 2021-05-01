package com.model;

public class Employee {

	private Integer emp_id;
	private String emp_first_name;
	private String emp_mid_name;
	private String  emp_last_name;
	private String designation;
	private String branch_ifsc;
	private String username;
	private String password;
	private String emp_role;
	//setter and getter
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_first_name() {
		return emp_first_name;
	}
	public void setEmp_first_name(String emp_first_name) {
		this.emp_first_name = emp_first_name;
	}
	public String getEmp_mid_name() {
		return emp_mid_name;
	}
	public void setEmp_mid_name(String emp_mid_name) {
		this.emp_mid_name = emp_mid_name;
	}
	public String getEmp_last_name() {
		return emp_last_name;
	}
	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getBranch_ifsc() {
		return branch_ifsc;
	}
	public void setBranch_ifsc(String branch_ifsc) {
		this.branch_ifsc = branch_ifsc;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmp_role() {
		return emp_role;
	}
	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}
	// default
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	// parameterized
	public Employee(Integer emp_id, String emp_first_name, String emp_mid_name, String emp_last_name,
			String designation, String branch_ifsc, String username, String password, String emp_role) {
		super();
		this.emp_id = emp_id;
		this.emp_first_name = emp_first_name;
		this.emp_mid_name = emp_mid_name;
		this.emp_last_name = emp_last_name;
		this.designation = designation;
		this.branch_ifsc = branch_ifsc;
		this.username = username;
		this.password = password;
		this.emp_role = emp_role;
	}
	

}
