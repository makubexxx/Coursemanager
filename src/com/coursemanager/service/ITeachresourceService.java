package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursedocument;
import com.coursemanager.model.Teachresource;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��5�� ����9:50:17
 */
public interface ITeachresourceService {

	
	public List<Teachresource> getteachresourcebycourseid(int courseid);
	
	public int insert(Teachresource teachresource);
}
