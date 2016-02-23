package com.coursemanager.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coursemanager.model.User;
import com.coursemanager.service.IRegisterService;

@Controller
public class RegisterController {
	private static Logger logger = Logger.getLogger(RegisterController.class);    
	@Resource
	private IRegisterService registerService;	
	
	@RequestMapping({"/register","/"})
	public String register(){  
		return "register";
	}
	@RequestMapping(value="/checkuser",method = RequestMethod.GET)
	public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		logger.info("into checkuser");
		User user =registerService.findbyid(1140611109);
		
			logger.info("user"+user.getUserName());
		
		return null;
	}
	
	
/*	@RequestMapping(value="/register/successed")
	public ModelAndView  successed(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username=(String)request.getParameter("username");	
		String email=(String)request.getParameter("email");		
		String password=(String)request.getParameter("password");
		if(username==null||email==null||password==null){
			return new ModelAndView("redirect:/register"); 
		}
		//新增用户插入数据库
		User user=new User();
		user.setUserName(username);
		user.setUserEmail(email);
		user.setUserPassword(password);
		registerService.insert(user);		
		//将数据转换成
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("username", username);  
		map.put("email", email);  
		map.put("password", password);  
		String json = JSONObject.fromObject(map).toString(); 		
		//将数据返回
		response.setCharacterEncoding("UTF-8");
		response.flushBuffer();
		response.getWriter().write(json);
		response.getWriter().flush();  
		response.getWriter().close();
		return new ModelAndView("successed",map);  
	}
	
*/
}
