package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.ChoiceCourse;
import com.coursemanager.model.Coursenotice;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��1�� ����9:41:29
 */
public interface ICoursenoticeService {

	
	public int insert(Coursenotice coursenotice);
	
	public List<Coursenotice> getallcoursenoticebycourseid(int courseid);
	
	public Coursenotice getdetailnoticebyid(int noticeid);
}
