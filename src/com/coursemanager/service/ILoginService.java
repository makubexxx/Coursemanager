package com.coursemanager.service;

import com.coursemanager.model.User;


/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月24日 下午9:04:28
 */
public interface ILoginService {

	public  boolean login(long userid,String passwd);

	public  User findUserbyid(long userid);
}
