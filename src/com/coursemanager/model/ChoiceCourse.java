package com.coursemanager.model;

import java.util.Date;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月27日 下午9:54:37
 */
public class ChoiceCourse {

	public int choiceid;

	public int courseid;

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String coursename;

	public String coursedate;

	public String teachername;

	public int userid;

	public Date startDate;

	public int getChoiceid() {
		return choiceid;
	}

	public void setChoiceid(int choiceid) {
		this.choiceid = choiceid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursedate() {
		return coursedate;
	}

	public void setCoursedate(String coursedate) {
		this.coursedate = coursedate;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}


