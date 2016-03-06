package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.ChoiceCourse;
import com.sun.org.apache.xml.internal.security.Init;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月27日 下午9:53:22
 */
public interface ICourseService {

	
	public List<ChoiceCourse> getallcoursebyuserid(int userid);
	
	public ChoiceCourse getdetailcourse(int choiceid);
}
