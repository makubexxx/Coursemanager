package com.coursemanager.model;

import java.util.Date;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午11:09:14
 */
public class Coursework {

	

	public int courseworkid;
	
	
	

	public String belongcourseid;
	
	

	public String   courseworktitle;
	
	
	

	public Date startDate;
	

	public Date endDate;
	
	public String   staue;

	public  int   courseworkworkmanager;

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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStaue() {
		return staue;
	}

	public void setStaue(String staue) {
		this.staue = staue;
	}

	public int getCourseworkworkmanager() {
		return courseworkworkmanager;
	}

	public void setCourseworkworkmanager(int courseworkworkmanager) {
		this.courseworkworkmanager = courseworkworkmanager;
	}
	
	
	
	
	
}
