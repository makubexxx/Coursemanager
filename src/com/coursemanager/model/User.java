package com.coursemanager.model;


public class User {
  
	public Long userid;


	public String user_name;

	public String passwd;


	public long user_phone;
	

	public String email;


	public int user_type;
	



	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public long getUser_phone() {
		return user_phone;
	}


	public void setUser_phone(long user_phone) {
		this.user_phone = user_phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getUser_type() {
		return user_type;
	}


	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}





}