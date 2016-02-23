package com.coursemanager.service;

import com.coursemanager.model.User;

public interface IRegisterService {
	
	public int insert(User user);
	
	public User findbyid(long userid);

}
