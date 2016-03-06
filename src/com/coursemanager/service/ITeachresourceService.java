package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursedocument;
import com.coursemanager.model.Teachresource;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午9:50:17
 */
public interface ITeachresourceService {

	
	public List<Teachresource> getteachresourcebycourseid(int courseid);
	
	public void insert(Teachresource teachresource);
}
