package com.coursemanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanager.mapper.UserMapper;
import com.coursemanager.model.User;
import com.coursemanager.service.ILoginService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月24日 下午9:10:16
 */
@Service
public class LoginServiceImpl implements ILoginService{

    @Autowired
	private UserMapper userMapper;
	@Override
	public boolean login(long userid, String passwd) {
		// TODO Auto-generated method stub
		User user =userMapper.findById(userid);
		if(user!=null)
		{
			if(user.getPasswd().equals(passwd)||user.getPasswd()==passwd)
			{
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

}
