package com.coursemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.CourseworkuploadMapper;
import com.coursemanager.model.Courseworkupload;
import com.coursemanager.service.ICourseworkuploadService;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version 创建时间：2016年4月8日 上午9:48:30  
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

}
