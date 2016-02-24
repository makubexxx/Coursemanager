package com.coursemanager.mapper;

import com.coursemanager.model.User;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月23日 下午8:00:27
 */
public interface UserMapper {

	void save(User user);
	boolean update(User user);
	User findById(long userid);
}
