package com.coursemanager.service;

import com.coursemanager.model.User;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version ����ʱ�䣺2016��3��31�� ����11:02:04  
 */
public interface IUserService {

	
	public User finduserbyid(long userid);
	
	public void updateuser(User user);
}
