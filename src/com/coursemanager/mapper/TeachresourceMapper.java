package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.Teachresource;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��5�� ����9:59:02
 */
public interface TeachresourceMapper {

	
	List<Teachresource> findbycourseid (int courseid);
}
