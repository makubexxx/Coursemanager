package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursediscuss;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 上午10:04:08
 */
public interface ICoursediscussService {

	
	public List<Coursediscuss> getteachresourcebycourseid(int courseid);
	
	public int  addCoursediscuss(Coursediscuss coursediscuss);
	
	public Coursediscuss findCoursediscussbyCoursediscussid(int Coursediscussid);
}
