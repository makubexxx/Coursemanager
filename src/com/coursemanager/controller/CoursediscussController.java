package com.coursemanager.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.Coursediscuss;
import com.coursemanager.model.User;
import com.coursemanager.service.ICoursediscussService;
import com.coursemanager.service.ILoginService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 下午1:10:41
 */
@Controller
public class CoursediscussController {
	
	
	
	private static Logger logger = Logger.getLogger(CoursediscussController.class);    

	@Resource
	private ICoursediscussService  coursediscussService;	

	@Resource
	private ILoginService  loginService;	
	
	
	//课程公告列表
	@RequestMapping(value="/coursediscusslist",method = RequestMethod.GET)
	public ModelAndView  coursediscusslist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Coursediscuss>  coursediscusslist =coursediscussService.getteachresourcebycourseid(courseid);
        logger.info("coursediscusslist:"+coursediscusslist.get(0).bycreate);
        modelAndView.addObject("coursediscusslist", coursediscusslist); 
        modelAndView.setViewName("coursediscusslist");    
        return modelAndView;  
}
	
	//课程公告列表
	@RequestMapping(value="/coursediscussdetail",method = RequestMethod.GET)
	public ModelAndView  coursediscussdetail(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Coursediscuss>  coursediscusslist =coursediscussService.getteachresourcebycourseid(courseid);
        logger.info("coursediscusslist:"+coursediscusslist.get(0).bycreate);
        modelAndView.addObject("coursediscusslist", coursediscusslist); 
        modelAndView.setViewName("coursediscusslist");
        
        return modelAndView;  
}

	//添加讨论主题
	@RequestMapping(value="/addcoursediscuss",method = RequestMethod.GET)
	public ModelAndView  addcoursediscuss(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		String content =request.getParameter("content");
		String title =request.getParameter("title");
		User user =(User) request.getSession().getAttribute("user");
		Coursediscuss coursediscuss = new  Coursediscuss();
		coursediscuss.setCoursediscusstitile(title);
		coursediscuss.setBycreate(user.getUser_name());
		coursediscuss.setBelongcourseid(courseid+"");
        coursediscuss.setPushtime(new Date());
        coursediscuss.setCoursediscusscontent(content);
        coursediscuss.setOnclick(0);
        coursediscuss.setResponse(0);
        coursediscussService.insert(coursediscuss);
        ModelAndView modelAndView = new ModelAndView();  

        List<Coursediscuss>  coursediscusslist =coursediscussService.getteachresourcebycourseid(courseid);
        logger.info("coursediscusslist:"+coursediscusslist.get(0).bycreate);
        modelAndView.addObject("coursediscusslist", coursediscusslist); 
        modelAndView.setViewName("coursediscusslist");
        
        return modelAndView;  
}
}
