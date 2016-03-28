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
	

	public String   reply_content;

	
	public Date reply_date;


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


	public String getReply_content() {
		return reply_content;
	}


	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}


	public Date getReply_date() {
		return reply_date;
	}


	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}



	
	
	
	
}
