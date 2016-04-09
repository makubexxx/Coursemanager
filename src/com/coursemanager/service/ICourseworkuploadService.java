package com.coursemanager.service;

import com.coursemanager.model.Courseworkupload;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version 创建时间：2016年4月8日 上午9:38:54  
 */
public interface ICourseworkuploadService {

	
public Courseworkupload findbyid(int courseid,int userid);
	
public int insert(Courseworkupload courseworkupload);
}
