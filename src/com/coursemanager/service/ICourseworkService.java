package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursework;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��6�� ����7:55:33
 */
public interface ICourseworkService {

	
	public List<Coursework> getCourseworkbycourseid(String courseid,int userid);
	
	public void insert(Coursework coursework);
	
	
	public Coursework  getCourseworkbyCourseworkid(int Courseworkid);
	
	public void update (int   staue, String attachment,int courseworkid );
}
