package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.ChoiceCourse;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月27日 下午10:02:04
 */
public interface ChoiceCourseMapper {

	
	List<ChoiceCourse> findByuserid (int userid);
	ChoiceCourse  findDetailcourse(int choiceid);
}
