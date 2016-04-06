package com.coursemanager.service;

import com.coursemanager.model.User;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version 创建时间：2016年3月31日 上午11:02:04  
 */
public interface IUserService {

	
	public User finduserbyid(long userid);
	
	public void updateuser(User user);
}
