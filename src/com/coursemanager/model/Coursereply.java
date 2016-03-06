package com.coursemanager.model;

import java.util.Date;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 下午2:28:23
 */
public class Coursereply {

	
	
	public int Coursereplyid;
	
	
	

	public String belongcoursediscussid;
	
	
	public String   replyuser;
	

	public String   replyContent;

	
	public Date replyDate;


	public int getCoursereplyid() {
		return Coursereplyid;
	}


	public void setCoursereplyid(int coursereplyid) {
		Coursereplyid = coursereplyid;
	}


	public String getBelongcoursediscussid() {
		return belongcoursediscussid;
	}


	public void setBelongcoursediscussid(String belongcoursediscussid) {
		this.belongcoursediscussid = belongcoursediscussid;
	}


	public String getReplyuser() {
		return replyuser;
	}


	public void setReplyuser(String replyuser) {
		this.replyuser = replyuser;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public Date getReplyDate() {
		return replyDate;
	}


	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	
	
	
	
}
