package com.coursemanager.mapper;

import com.coursemanager.model.Courseworkupload;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version ����ʱ�䣺2016��4��8�� ����9:56:46  
 */
public interface CourseworkuploadMapper {

	
	int save(Courseworkupload courseworkupload);
	
	Courseworkupload findBycourseidanduserid (int courseworkid ,int userid);
	
	int update(int courseworkid ,int userid,String score);
}
