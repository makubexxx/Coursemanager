package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.Coursediscuss;
import com.coursemanager.model.User;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��6�� ����10:10:30
 */
public interface CoursediscussMapper {

	
	
	List<Coursediscuss> findbycourseid (int courseid);
	
	Coursediscuss findbyCoursediscussid(int coursediscussid);

	int save(Coursediscuss coursediscuss);
}
