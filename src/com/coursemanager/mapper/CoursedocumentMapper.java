package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.Coursedocument;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午2:57:31
 */
public interface CoursedocumentMapper {

/*	void save(Coursedocument coursedocument);*/
	
	List<Coursedocument> findbycourseid (int courseid);
}
