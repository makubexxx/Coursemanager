package com.coursemanager.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.UserMapper;
import com.coursemanager.model.User;
import com.coursemanager.service.IRegisterService;
@Service("registerService")
public class RegisterServiceImpl implements IRegisterService{
	private static Logger logger = Logger.getLogger(RegisterServiceImpl.class);  
	 @Autowired
	private UserMapper userMapper;

	@Override
	public void insert(User user) {	
		try {
			
			 userMapper.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	


	@Override
	public User findbyid(long userid) {
		// TODO Auto-generated method stub
		return userMapper.findById(userid);
	}

}
