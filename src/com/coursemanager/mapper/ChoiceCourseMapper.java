package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.ChoiceCourse;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��2��27�� ����10:02:04
 */
public interface ChoiceCourseMapper {

	
	List<ChoiceCourse> findByuserid (int userid);
	ChoiceCourse  findDetailcourse(int choiceid);
}
