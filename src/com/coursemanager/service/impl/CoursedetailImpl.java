package com.coursemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.CoursedetailMapper;
import com.coursemanager.model.Coursedetail;
import com.coursemanager.service.ICoursedetailService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��3�� ����11:19:42
 */
@Service
public class CoursedetailImpl implements ICoursedetailService {

    @Autowired
	private CoursedetailMapper coursedetailMapper;
	@Override
	public Coursedetail getcoursedetailbyid(int courseid) {
		// TODO Auto-generated method stub
		return coursedetailMapper.findBycourseId(courseid);
	}

}
