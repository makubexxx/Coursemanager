package com.coursemanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.CoursereplyMapper;
import com.coursemanager.model.Coursereply;
import com.coursemanager.service.ICoursereplyService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 下午2:36:43
 */
@Service
public class CoursereplyServiceImpl implements ICoursereplyService{

    @Autowired
	private CoursereplyMapper coursereplyMapper;


	@Override
	public void insert(Coursereply coursereply) {
		// TODO Auto-generated method stub
		coursereplyMapper.save(coursereply);
	}

	@Override
	public List<Coursereply> getCoursereplyebycoursediscussid(
			int coursediscussid) {
		// TODO Auto-generated method stub
		return coursereplyMapper.findbybelongcoursediscussid(coursediscussid);
	}

}
