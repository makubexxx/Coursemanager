package com.coursemanager.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coursemanager.service.ILoginService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��2��24�� ����8:58:12
 */
@Controller
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);    
	@Resource
	private ILoginService loginService;	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		String userid =request.getParameter("userid");
		String passwd =request.getParameter("passwd");
		logger.info("getparams>>>>>"+"userid:"+userid+"----"+"passwd:"+passwd);
		if(loginService.login(Long.parseLong(userid), passwd)==true)
		{
			return "studentmain";
		}
     
		return null;
}
}