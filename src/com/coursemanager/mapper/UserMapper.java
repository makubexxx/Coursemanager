package com.coursemanager.mapper;

import com.coursemanager.model.User;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��2��23�� ����8:00:27
 */
public interface UserMapper {

	void save(User user);
	boolean update(User user);
	User findById(long userid);
}
