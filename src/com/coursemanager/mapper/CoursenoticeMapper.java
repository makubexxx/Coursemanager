package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.Coursenotice;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��1�� ����9:43:26
 */
public interface CoursenoticeMapper {

	void save(Coursenotice coursenotice);
	
	List<Coursenotice> findBycourseid (int courseid);
	
	Coursenotice  getCoursenoticebyid(int noticeid);
}
