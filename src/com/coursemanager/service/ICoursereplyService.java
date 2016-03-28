package com.coursemanager.service;

import java.util.List;

import com.coursemanager.model.Coursereply;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 下午2:31:50
 */
public interface ICoursereplyService {

	
	public List<Coursereply> getCoursereplyebycoursediscussid(int coursediscussid);
	
	public void insert(Coursereply coursereply);
}
