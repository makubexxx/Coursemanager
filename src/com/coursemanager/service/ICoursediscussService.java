package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursediscuss;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��6�� ����10:04:08
 */
public interface ICoursediscussService {

	
	public List<Coursediscuss> getteachresourcebycourseid(int courseid);
	
	public void insert(Coursediscuss coursediscuss);
	
	public Coursediscuss findCoursediscussbyCoursediscussid(int Coursediscussid);
}
