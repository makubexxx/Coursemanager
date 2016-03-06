package com.coursemanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.CoursedocumentMapper;
import com.coursemanager.model.Coursedocument;
import com.coursemanager.service.ICoursedocumentService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��5�� ����2:54:08
 */
@Service
public class CoursedocumentImpl implements ICoursedocumentService{

    @Autowired
	private CoursedocumentMapper CoursedocumentMapper;
	@Override
	public List<Coursedocument> getallcoursedocumentbycourseid(int courseid) {
		// TODO Auto-generated method stub
		return CoursedocumentMapper.findbycourseid(courseid);
	}

	@Override
	public void insert(Coursedocument coursedocument) {
		// TODO Auto-generated method stub
		
	}

}
