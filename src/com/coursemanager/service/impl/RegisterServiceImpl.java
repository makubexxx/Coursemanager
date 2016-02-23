package com.coursemanager.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.UserMapper;
import com.coursemanager.model.User;
import com.coursemanager.service.IRegisterService;
@Service("registerService")
public class RegisterServiceImpl implements IRegisterService{
	private static Logger logger = Logger.getLogger(RegisterServiceImpl.class);  
	@Resource
	private UserMapper userMapper;

	@Override
	public int insert(User user) {	
		try {
			
			return userMapper.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	


	@Override
	public User findbyid(long userid) {
		// TODO Auto-generated method stub
		return userMapper.findById(userid);
	}

}
