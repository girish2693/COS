package com.model;

import java.io.Serializable;
import java.sql.Date;

public class Account implements Serializable {
	private String account_number;
	private String acc_type;
	private Integer balance;
	private String first_name;
	private String mid_name;
	private String last_name;
	private Date date_of_birth;
	private String gender;
	private String mobile_num;
	private String email_id;
	private String address;
	private String pin;
	private String pan;
	private String aadhar;
	private String city;
	private String state;
	private String country;
	private String occupation;
	private Integer salary;
	private String status;
	private Date open_date;
	private Date close_date;
	private String nominee;
	private String branch_ifsc;
	private String bill_pay_preferred;
	private Integer customer_id;
	// seters and geters
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMid_name() {
		return mid_name;
	}
	public void setMid_name(String mid_name) {
		if(mid_name!=null)
	    	this.mid_name = mid_name.toLowerCase();
		else
			this.mid_name="";
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public Date getClose_date() {
		return close_date;
	}
	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}
	public String getNominee() {
		return nominee;
	}
	public void setNominee(String nominee) {
		this.nominee = nominee;
	}
	public String getBraanch_IFSC() {
		return branch_ifsc;
	}
	public void setBraanch_IFSC(String branch_ifsc) {
		this.branch_ifsc = branch_ifsc;
	}
	public String getBill_pay_preferred() {
		return bill_pay_preferred;
	}
	public void setBill_pay_preferred(String bill_pay_preferred) {
		this.bill_pay_preferred = bill_pay_preferred;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	// default
	public Account() {
		
	}
	// parameterized
	public Account(String account_number, String acc_type, Integer balance, String first_name, String mid_name,
			String last_name, Date date_of_birth, String gender, String mobile_num, String email_id, String address,
			String pin, String pan, String aadhar, String city, String state,String country, String occupation, Integer salary,
			String status, Date open_date, Date close_date, String nominee, String branch_ifsc,
			String bill_pay_preferred, Integer customer_id) {
		super();
		this.account_number = account_number;
		this.acc_type = acc_type;
		this.balance = balance;
		this.first_name = first_name;
		this.mid_name = mid_name;
		this.last_name = last_name;
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
		this.country=country;
		this.occupation = occupation;
		this.salary = salary;
		this.status = status;
		this.open_date = open_date;
		this.close_date = close_date;
		this.nominee = nominee;
		this.branch_ifsc = branch_ifsc;
		this.bill_pay_preferred = bill_pay_preferred;
		this.customer_id = customer_id;
	}
	//
	public Account(String account_number, String first_name, String mid_name,
			String last_name, String address,String city,String pin, String mobile_num, Date date_of_birth,
			String status, String pan) {
		this.account_number = account_number;
		this.first_name = first_name;
		this.mid_name = mid_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.mobile_num = mobile_num;
		this.address = address;
		this.pin = pin;
		this.pan = pan;
		this.city = city;
		this.status = status;
	}
}
