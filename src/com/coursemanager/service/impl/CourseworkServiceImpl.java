package com.coursemanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.CourseworkMapper;
import com.coursemanager.model.Coursework;
import com.coursemanager.service.ICourseworkService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��6�� ����7:56:38
 */
@Service
public class CourseworkServiceImpl implements ICourseworkService {
	
	
    @Autowired
	private CourseworkMapper courseworkMapper;

	@Override
	public List<Coursework> getCourseworkbycourseid(String courseid) {
		// TODO Auto-generated method stub
		return courseworkMapper.findBycourseid(courseid);
	}

	@Override
	public int insert(Coursework coursework) {
		// TODO Auto-generated method stub
		return  courseworkMapper.save(coursework);
		
	}

	@Override
	public Coursework getCourseworkbyCourseworkid(int Courseworkid) {
		// TODO Auto-generated method stub
		return courseworkMapper.findByCourseworkid(Courseworkid);
	}



	@Override
	public void update(int staue, String attachment, int courseworkid) {
		// TODO Auto-generated method stub
		courseworkMapper.update(staue, attachment, courseworkid);
	}

}
