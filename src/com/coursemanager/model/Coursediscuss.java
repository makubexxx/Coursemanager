package com.coursemanager.model;

import java.util.Date;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 上午9:57:54
 */
public class Coursediscuss {

	public int coursediscussid;

	public String  coursediscusstitile;



	public String belongcourseid;
	

	public String 	bycreate;
	
	public String coursediscusscontent;
	
	public int onclick;
	
	
	
	public int response;
	

	public Date pushtime;


	public int getCoursediscussid() {
		return coursediscussid;
	}


	public void setCoursediscussid(int coursediscussid) {
		this.coursediscussid = coursediscussid;
	}


	public String getCoursediscusstitile() {
		return coursediscusstitile;
	}


	public void setCoursediscusstitile(String coursediscusstitile) {
		this.coursediscusstitile = coursediscusstitile;
	}


	public String getBelongcourseid() {
		return belongcourseid;
	}


	public void setBelongcourseid(String belongcourseid) {
		this.belongcourseid = belongcourseid;
	}


	public String getBycreate() {
		return bycreate;
	}


	public void setBycreate(String bycreate) {
		this.bycreate = bycreate;
	}


	public int getOnclick() {
		return onclick;
	}


	public void setOnclick(int onclick) {
		this.onclick = onclick;
	}


	public int getResponse() {
		return response;
	}


	public void setResponse(int response) {
		this.response = response;
	}


	public Date getPushtime() {
		return pushtime;
	}


	public void setPushtime(Date pushtime) {
		this.pushtime = pushtime;
	}


	public String getCoursediscusscontent() {
		return coursediscusscontent;
	}


	public void setCoursediscusscontent(String coursediscusscontent) {
		this.coursediscusscontent = coursediscusscontent;
	}
	
	
	
	


}
