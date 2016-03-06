package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursedocument;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午2:44:52
 */
public interface ICoursedocumentService {

	
	public List<Coursedocument> getallcoursedocumentbycourseid(int courseid);
	
	public void insert(Coursedocument coursedocument);
}
