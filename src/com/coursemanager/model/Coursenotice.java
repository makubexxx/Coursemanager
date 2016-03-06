package com.coursemanager.model;

import java.util.Date;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月1日 下午9:40:01
 */
public class Coursenotice {


		
		private static final long serialVersionUID = 1L;

		public int noticeid;

		public int courseid;

		public String noticetitle;


		public String noticecontext;
		
		public String byuser;

		public int userid;
		

		public Date pushda_date;
		
		
		
		

		public int getNoticeid() {
			return noticeid;
		}


		public void setNoticeid(int noticeid) {
			this.noticeid = noticeid;
		}


		public int getCourseid() {
			return courseid;
		}


		public void setCourseid(int courseid) {
			this.courseid = courseid;
		}


		public String getNoticetitle() {
			return noticetitle;
		}


		public void setNoticetitle(String noticetitle) {
			this.noticetitle = noticetitle;
		}


		public String getNoticecontext() {
			return noticecontext;
		}


		public void setNoticecontext(String noticecontext) {
			this.noticecontext = noticecontext;
		}


		public String getByuser() {
			return byuser;
		}


		public void setByuser(String byuser) {
			this.byuser = byuser;
		}


		public int getUserid() {
			return userid;
		}


		public void setUserid(int userid) {
			this.userid = userid;
		}


		public Date getPushda_date() {
			return pushda_date;
		}


		public void setPushda_date(Date pushda_date) {
			this.pushda_date = pushda_date;
		}



	

}
