package com.coursemanager.service;

import com.coursemanager.model.User;


/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��2��24�� ����9:04:28
 */
public interface ILoginService {

	public  boolean login(long userid,String passwd);

	public  User findUserbyid(long userid);
}
