package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursedocument;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��5�� ����2:44:52
 */
public interface ICoursedocumentService {

	
	public List<Coursedocument> getallcoursedocumentbycourseid(int courseid);
	
	public int insert(Coursedocument coursedocument);
}
