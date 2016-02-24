package com.coursemanager.service;

import com.coursemanager.model.User;

public interface IRegisterService {
	
	public void insert(User user);
	
	public User findbyid(long userid);

}
