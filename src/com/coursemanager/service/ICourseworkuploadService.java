package com.coursemanager.service;

import com.coursemanager.model.Courseworkupload;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version ����ʱ�䣺2016��4��8�� ����9:38:54  
 */
public interface ICourseworkuploadService {

	
public Courseworkupload findbyid(int courseid,int userid);
	
public int insert(Courseworkupload courseworkupload);
}
