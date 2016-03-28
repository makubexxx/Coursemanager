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
	
	
	

	public Date start_date;
	

	public Date end_date;
	
	public int   statue;

	public int  score;
	
	public int userid;
	
   public String attachment;
   
   public String coursework_content;
   
   
   public String statuedescrpition;

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


	


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
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

	public String getStatuedescrpition() {
		return statuedescrpition;
	}

	public void setStatuedescrpition(String statuedescrpition) {
		this.statuedescrpition = statuedescrpition;
	}

	public String getCoursework_content() {
		return coursework_content;
	}

	public void setCoursework_content(String coursework_content) {
		this.coursework_content = coursework_content;
	}

	public int getStatue() {
		return statue;
	}

	public void setStatue(int statue) {
		this.statue = statue;
	}


	
	
	
}
