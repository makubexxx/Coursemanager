package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.Coursedocument;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��5�� ����2:57:31
 */
public interface CoursedocumentMapper {

	int save(Coursedocument coursedocument);
	
	List<Coursedocument> findbycourseid (int courseid);
}
