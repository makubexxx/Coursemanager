package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.ChoiceCourse;
import com.sun.org.apache.xml.internal.security.Init;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��2��27�� ����9:53:22
 */
public interface ICourseService {

	
	public List<ChoiceCourse> getallcoursebyuserid(long userid);
	
	public ChoiceCourse getdetailcourse(int choiceid);
}
