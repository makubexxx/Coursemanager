package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.Coursereply;
import com.coursemanager.model.User;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 下午2:37:13
 */
public interface CoursereplyMapper {

	void save(Coursereply coursereply);
	
	List<Coursereply> findbybelongcoursediscussid (int belongcoursediscussid);
}
