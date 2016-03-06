package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.ChoiceCourse;
import com.coursemanager.model.Coursenotice;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月1日 下午9:41:29
 */
public interface ICoursenoticeService {

	
	public void insert(Coursenotice coursenotice);
	
	public List<Coursenotice> getallcoursenoticebycourseid(int courseid);
	
	public Coursenotice getdetailnoticebyid(int noticeid);
}
