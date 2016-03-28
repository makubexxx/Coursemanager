package com.coursemanager.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.ChoiceCourse;
import com.coursemanager.model.User;
import com.coursemanager.service.ILoginService;
import com.coursemanager.service.IRegisterService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月24日 下午8:58:12
 */
@Controller
public class LoginController {

	private static Logger logger = Logger.getLogger(LoginController.class);    
	@Resource
	private ILoginService loginService;	
	@Resource
	private IRegisterService registerService;	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ModelAndView  login(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		String userid =request.getParameter("userid");
		String passwd =request.getParameter("passwd");
		logger.info("getparams>>>>>"+"userid:"+userid+"----"+"passwd:"+passwd);
	    User user = registerService.findbyid(Long.parseLong(userid));
		
        ModelAndView modelAndView = new ModelAndView();  
        logger.info("flag"+user.getPasswd().equals(passwd)+"pwd:"+user.getPasswd());
		if(user.getPasswd().equals(passwd))
		{
			HttpSession session =request.getSession();
			session.setAttribute("user", user);
	        modelAndView.addObject("user", user);  
	        if(user.getUser_type()==10)
	        {
	            modelAndView.setViewName("teachermain"); 
	        }else if(user.getUser_type()==0) {
	            modelAndView.setViewName("studentmain"); 
			}
	    
	        return modelAndView;  
		}
		else{
	      modelAndView.setViewName("error");  }
	       return modelAndView; 
}
	
	
	@RequestMapping(value="/userinfo",method = RequestMethod.GET)
	public ModelAndView  showuserinfo(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		User user =(User) request.getSession().getAttribute("user");	
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("user", user);  
        modelAndView.setViewName("userinfo");  
        return modelAndView;  
}
}