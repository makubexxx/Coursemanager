package com.coursemanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.CoursediscussMapper;
import com.coursemanager.mapper.TeachresourceMapper;
import com.coursemanager.model.Coursediscuss;
import com.coursemanager.service.ICoursediscussService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 上午10:06:35
 */
@Service
public class CoursediscussServiceImpl implements ICoursediscussService{

	

    @Autowired
	private CoursediscussMapper coursediscussMapper;
	@Override
	public List<Coursediscuss> getteachresourcebycourseid(int courseid) {
		// TODO Auto-generated method stub
		return coursediscussMapper.findbycourseid(courseid);
	}

	@Override
	public void insert(Coursediscuss coursediscuss) {
		// TODO Auto-generated method stub
		
	}

}
