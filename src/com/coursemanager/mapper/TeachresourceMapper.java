package com.coursemanager.mapper;

import java.util.List;

import com.coursemanager.model.Coursenotice;
import com.coursemanager.model.Teachresource;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午9:59:02
 */
public interface TeachresourceMapper {

	
	List<Teachresource> findbycourseid (int courseid);
	int save(Teachresource teachresource);
}
