package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursework;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 下午7:55:33
 */
public interface ICourseworkService {

	
	public List<Coursework> getCourseworkbycourseid(String courseid);
	
	public int insert(Coursework coursework);
	
	
	public Coursework  getCourseworkbyCourseworkid(int Courseworkid);
	
	public void update (int   staue, String attachment,int courseworkid );
}
