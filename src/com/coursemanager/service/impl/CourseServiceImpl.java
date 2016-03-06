package com.coursemanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.ChoiceCourseMapper;
import com.coursemanager.model.ChoiceCourse;
import com.coursemanager.service.ICourseService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��2��27�� ����9:57:46
 */
@Service
public class CourseServiceImpl implements ICourseService{

	 @Autowired
	private ChoiceCourseMapper choiceCourseMapper;
	@Override
	public List<ChoiceCourse> getallcoursebyuserid(int userid) {
		// TODO Auto-generated method stub
		return choiceCourseMapper.findByuserid(userid);
	}
	
	@Override
	public    ChoiceCourse   getdetailcourse (int choiceid) {
		// TODO Auto-generated method stub
		return choiceCourseMapper.findDetailcourse(choiceid);
	}

}
