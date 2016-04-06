package com.coursemanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.CoursenoticeMapper;
import com.coursemanager.model.Coursenotice;
import com.coursemanager.service.ICoursenoticeService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月1日 下午9:58:16
 */
@Service
public class CoursenoticeImpl implements ICoursenoticeService {

    @Autowired
	private CoursenoticeMapper coursenoticeMapper;
	@Override
	public int insert(Coursenotice coursenotice) {
		// TODO Auto-generated method stub
		return  coursenoticeMapper.save(coursenotice);
	}



	@Override
	public List<Coursenotice> getallcoursenoticebycourseid(int courseid) {
		// TODO Auto-generated method stub
		return coursenoticeMapper.findBycourseid(courseid);
	}



	@Override
	public Coursenotice getdetailnoticebyid(int noticeid) {
		// TODO Auto-generated method stub
		return coursenoticeMapper.getCoursenoticebyid(noticeid);
	}

}
