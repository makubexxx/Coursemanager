package com.coursemanager.mapper;

import com.coursemanager.model.Coursedetail;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月3日 下午11:20:46
 */
public interface CoursedetailMapper {

	Coursedetail  findBycourseId(int courseid);
}
