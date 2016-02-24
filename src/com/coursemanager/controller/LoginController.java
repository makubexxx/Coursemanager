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
 * @version 创建时间：2016年2月24日 下午8:58:12
 */
@Controller
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);    
	@Resource
	private ILoginService loginService;	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		logger.info("result:"+loginService.login(11406111019L, "1234"));
     
		return null;
}
}