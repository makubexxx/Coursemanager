package com.coursemanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.coursemanager.model.Coursework;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 下午7:57:36
 */
public interface CourseworkMapper {

	int save(Coursework coursework);
	
	List<Coursework> findBycourseid (String courseid );
	
	Coursework findByCourseworkid (int  Courseworkid);
	
	void update (int   staue, String attachment,int courseworkid );
	
}
