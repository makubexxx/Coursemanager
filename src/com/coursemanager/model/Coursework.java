package com.coursemanager.model;

import java.util.Date;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��5�� ����11:09:14
 */
public class Coursework {

	

	public int courseworkid;
	
	
	

	public String belongcourseid;
	
	

	public String   courseworktitle;
	
	
	

	public Date start_date;
	

	public Date end_date;


	public int getCourseworkid() {
		return courseworkid;
	}


	public void setCourseworkid(int courseworkid) {
		this.courseworkid = courseworkid;
	}


	public String getBelongcourseid() {
		return belongcourseid;
	}


	public void setBelongcourseid(String belongcourseid) {
		this.belongcourseid = belongcourseid;
	}


	public String getCourseworktitle() {
		return courseworktitle;
	}


	public void setCourseworktitle(String courseworktitle) {
		this.courseworktitle = courseworktitle;
	}


	public Date getStart_date() {
		return start_date;
	}


	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	






	
	
	
}
