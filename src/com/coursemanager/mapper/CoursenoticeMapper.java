package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.Coursenotice;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月1日 下午9:43:26
 */
public interface CoursenoticeMapper {

	int save(Coursenotice coursenotice);
	
	List<Coursenotice> findBycourseid (int courseid);
	
	Coursenotice  getCoursenoticebyid(int noticeid);
}
