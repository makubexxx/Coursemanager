package com.coursemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.CourseworkuploadMapper;
import com.coursemanager.model.Courseworkupload;
import com.coursemanager.service.ICourseworkuploadService;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version ����ʱ�䣺2016��4��8�� ����9:48:30  
 */
@Service
public class CourseworkuploadImpl implements ICourseworkuploadService{


	 @Autowired
	private CourseworkuploadMapper courseworkuploadMapper;
	@Override
	public Courseworkupload findbyid(int courseid, int userid) {
		// TODO Auto-generated method stub
		return courseworkuploadMapper.findBycourseidanduserid(courseid,userid);
	}


	@Override
	public int insert(Courseworkupload courseworkupload) {
		// TODO Auto-generated method stub
		return courseworkuploadMapper.save(courseworkupload);
	}





	@Override
	public int update(int courseworkid, int userid, String score) {
		// TODO Auto-generated method stub
		return courseworkuploadMapper.update(courseworkid, userid, score);
	}

}
