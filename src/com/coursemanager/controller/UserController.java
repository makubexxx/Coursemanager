package com.coursemanager.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.User;
import com.coursemanager.service.ILoginService;
import com.coursemanager.service.IUserService;
import com.coursemanager.util.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月24日 下午8:58:12
 */
@Controller
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);    
	@Resource
	private ILoginService loginService;	
	@Resource
	private IUserService userService;	
	public static Gson gsonBuilderWithExpose = new GsonBuilder()
	.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ModelAndView  login(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		String userid =request.getParameter("userid");
		String passwd =request.getParameter("passwd");
		logger.info("getparams>>>>>"+"userid:"+userid+"----"+"passwd:"+passwd);
	    User user = userService.finduserbyid(Long.parseLong(userid));
		
        ModelAndView modelAndView = new ModelAndView();  
		if(user!=null&&user.getPasswd().equals(passwd))
		{
			HttpSession session =request.getSession();
			session.setAttribute("user", user);
	        modelAndView.addObject("user", user);  
	        if(user.getUser_type()==10)
	        {
	            modelAndView.setViewName("teacher/usermain"); 
	        }else if(user.getUser_type()==0) {
	            modelAndView.setViewName("student/usermain"); 
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
	
	@RequestMapping(value="/changeuserinfo",method = RequestMethod.GET)
	public void  changeuserinfo(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		User user =(User) request.getSession().getAttribute("user");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String telephone=request.getParameter("telephone");
		logger.info("change userinfo         name:"+name+"email"+email+"phone:"+telephone);
		user.setEmail(email);
		user.setUser_name(name);
		user.setUser_phone(Long.valueOf(telephone));
		userService.updateuser(user);
		User findUser =userService.finduserbyid(user.getUserid());
        HashMap<String, Object>  map =new  HashMap<String, Object>();
        //查询数据库如果用户名已经修改了。说明修改成功，否则失败
        logger.info("finduser name:"+findUser.getUser_name());
        if(findUser.getUser_name().equals(name))
        {
        	map.put("statue", 0);
        	}
        else {
        	map.put("statue", 1);
		}
       Response.response(gsonBuilderWithExpose.toJson(map),response);
}
}