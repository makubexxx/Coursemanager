package com.coursemanager.model;

import java.util.Date;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午2:35:33
 */
public class Coursedocument {

	
	private static final long serialVersionUID = 1L;
	

	public int coursedocumentid;

	public String  coursedocumenttitile;

	public String coursedocument_description;

	

	public int belongcourseid;
	

	public float documentsize;
	
	

	public Date uploadtime;
	
	public String 	doucumenturl;

	public int getCoursedocumentid() {
		return coursedocumentid;
	}

	public void setCoursedocumentid(int coursedocumentid) {
		this.coursedocumentid = coursedocumentid;
	}

	public String getCoursedocumenttitile() {
		return coursedocumenttitile;
	}

	public void setCoursedocumenttitile(String coursedocumenttitile) {
		this.coursedocumenttitile = coursedocumenttitile;
	}



	public int getBelongcourseid() {
		return belongcourseid;
	}

	public void setBelongcourseid(int belongcourseid) {
		this.belongcourseid = belongcourseid;
	}

	public float getDocumentsize() {
		return documentsize;
	}

	public void setDocumentsize(float documentsize) {
		this.documentsize = documentsize;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getDoucumenturl() {
		return doucumenturl;
	}

	public void setDoucumenturl(String doucumenturl) {
		this.doucumenturl = doucumenturl;
	}

	public String getCoursedocument_description() {
		return coursedocument_description;
	}

	public void setCoursedocument_description(String coursedocument_description) {
		this.coursedocument_description = coursedocument_description;
	}
	
	
	
	
}
