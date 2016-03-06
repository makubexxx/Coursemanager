package com.coursemanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.TeachresourceMapper;
import com.coursemanager.model.Teachresource;
import com.coursemanager.service.ITeachresourceService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午9:54:14
 */
@Service
public class TeachresourceImpl implements ITeachresourceService{


    @Autowired
	private TeachresourceMapper teachresourceMapper;
	@Override
	public List<Teachresource> getteachresourcebycourseid(int courseid) {
		// TODO Auto-generated method stub
		return teachresourceMapper.findbycourseid(courseid);
	}

	@Override
	public void insert(Teachresource teachresource) {
		// TODO Auto-generated method stub
		
	}

}
