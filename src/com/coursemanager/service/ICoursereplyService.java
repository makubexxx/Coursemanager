package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursereply;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��6�� ����2:31:50
 */
public interface ICoursereplyService {

	
	public List<Coursereply> getCoursereplyebycoursediscussid(int coursediscussid);
	
	public void insert(Coursereply coursereply);
}
