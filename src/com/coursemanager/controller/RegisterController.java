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
	
	@RequestMapping("/register")
	public String register(){  
		return "register";
	}
	@RequestMapping(value="/checkuser",method = RequestMethod.GET)
	public String checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		logger.info("into checkuser");
		User user =registerService.findbyid(11406111019L);
		
			logger.info("user"+user.getUser_name());
		
		return null;
	}
	
	@RequestMapping(value="/save",method = RequestMethod.GET)
	public String saveUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		User user = new User();
		user.setUserid(11406111019L);
		user.setEmail("sasdasd");
		user.setPasswd("1234");
		user.setUser_name("hhee");
		user.setUser_type(1);
		user.setUser_phone(1111232323L);

		registerService.insert(user);
		
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
		//�����û��������ݿ�
		User user=new User();
		user.setUserName(username);
		user.setUserEmail(email);
		user.setUserPassword(password);
		registerService.insert(user);		
		//������ת����
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("username", username);  
		map.put("email", email);  
		map.put("password", password);  
		String json = JSONObject.fromObject(map).toString(); 		
		//�����ݷ���
		response.setCharacterEncoding("UTF-8");
		response.flushBuffer();
		response.getWriter().write(json);
		response.getWriter().flush();  
		response.getWriter().close();
		return new ModelAndView("successed",map);  
	}
	
*/
}
