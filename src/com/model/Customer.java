package com.model;

import java.io.Serializable;
import java.sql.Date;

public class Customer implements Serializable {
	private String customer_id;
	private String cust_first_name;
	private String cust_mid_name;
	private String cust_last_name;
	private String date_of_birth;
	private String gender;
	private String mobile_num;
	private String email_id;
	private String address;
	private String pin;
	private String pan;
	private String aadhar;
	private String city;
	private String state;
	private String occupation;
	private String salary;
	private Date relationship_start_date;
	private String cust_username;
	private String cust_password;
	private String preferred_acc_1;
	private String preferred_acc_2;
	private String bill_pay_registered;
	// setter and getter
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCust_first_name() {
		return cust_first_name;
	}
	public void setCust_first_name(String cust_first_name) {
		this.cust_first_name = cust_first_name;
	}
	public String getCust_mid_name() {
		return cust_mid_name;
	}
	public void setCust_mid_name(String cust_mid_name) {
		this.cust_mid_name = cust_mid_name;
	}
	public String getCust_last_name() {
		return cust_last_name;
	}
	public void setCust_last_name(String cust_last_name) {
		this.cust_last_name = cust_last_name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Date getRelationship_start_date() {
		return relationship_start_date;
	}
	public void setRelationship_start_date(Date relationship_start_date) {
		this.relationship_start_date = relationship_start_date;
	}
	
	public String getCust_username() {
		return cust_username;
	}
	public void setCust_username(String cust_username) {
		this.cust_username = cust_username;
	}
	public String getCust_password() {
		return cust_password;
	}
	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}
	public String getPreferred_acc_1() {
		return preferred_acc_1;
	}
	public void setPreferred_acc_1(String preferred_acc_1) {
		this.preferred_acc_1 = preferred_acc_1;
	}
	public String getPreferred_acc_2() {
		return preferred_acc_2;
	}
	public void setPreferred_acc_2(String preferred_acc_2) {
		this.preferred_acc_2 = preferred_acc_2;
	}
	public String getBill_pay_registered() {
		return bill_pay_registered;
	}
	public void setBill_pay_registered(String bill_pay_registered) {
		this.bill_pay_registered = bill_pay_registered;
	}
	//default
	public Customer() {
		
	}
	// parameterized
	public Customer(String customer_id, String cust_first_name, String cust_mid_name, String cust_last_name,
			String date_of_birth, String gender, String mobile_num, String email_id, String address, String pin,
			String pan, String aadhar, String city, String state, String occupation,String salary,
			Date relationship_start_date, String cust_username, String cust_password, String preferred_acc_1,
			String preferred_acc_2, String bill_pay_registered) {
		super();
		this.customer_id = customer_id;
		this.cust_first_name = cust_first_name;
		this.cust_mid_name = cust_mid_name;
		this.cust_last_name = cust_last_name;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.mobile_num = mobile_num;
		this.email_id = email_id;
		this.address = address;
		this.pin = pin;
		this.pan = pan;
		this.aadhar = aadhar;
		this.city = city;
		this.state = state;
		this.occupation = occupation;
		this.salary = salary;
		this.relationship_start_date = relationship_start_date;
		this.cust_username = cust_username;
		this.cust_password = cust_password;
		this.preferred_acc_1 = preferred_acc_1;
		this.preferred_acc_2 = preferred_acc_2;
		this.bill_pay_registered = bill_pay_registered;
	}
	
	
	
}
