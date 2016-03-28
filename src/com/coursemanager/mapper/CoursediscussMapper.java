package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.Coursediscuss;
import com.coursemanager.model.User;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 上午10:10:30
 */
public interface CoursediscussMapper {

	
	
	List<Coursediscuss> findbycourseid (int courseid);
	
	Coursediscuss findbyCoursediscussid(int coursediscussid);
	

	void save(Coursediscuss coursediscuss);
}
