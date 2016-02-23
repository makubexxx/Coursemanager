package com.coursemanager.model;


public class User {
  
	public Long userid;


	public String userName;


	public String passwd;


	public long userPhone;
	

	public String email;


	public int userType;


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public long getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getUserType() {
		return userType;
	}


	public void setUserType(int userType) {
		this.userType = userType;
	}


}