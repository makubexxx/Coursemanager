package com.coursemanager.mapper;

import com.coursemanager.model.Coursedetail;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��3�� ����11:20:46
 */
public interface CoursedetailMapper {

	Coursedetail  findBycourseId(int courseid);
}
