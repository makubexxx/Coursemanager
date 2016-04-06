package com.coursemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.UserMapper;
import com.coursemanager.model.User;
import com.coursemanager.service.IUserService;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version 创建时间：2016年3月31日 上午11:06:43  
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
	private UserMapper userMapper;
	
	@Override
	public User finduserbyid(long userid) {
		// TODO Auto-generated method stub
		return userMapper.findById(userid);
	}




	@Override
	public void updateuser(User user) {
		// TODO Auto-generated method stub
		 userMapper.update(user);
	}

}
