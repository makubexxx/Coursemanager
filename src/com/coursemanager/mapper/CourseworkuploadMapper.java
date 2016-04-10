package com.coursemanager.mapper;

import com.coursemanager.model.Courseworkupload;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version 创建时间：2016年4月8日 上午9:56:46  
 */
public interface CourseworkuploadMapper {

	
	int save(Courseworkupload courseworkupload);
	
	Courseworkupload findBycourseidanduserid (int courseworkid ,int userid);
	
	int update(int courseworkid ,int userid,String score);
}
