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
import com.coursemanager.model.Coursereply;
import com.coursemanager.model.User;
import com.coursemanager.service.ICoursediscussService;
import com.coursemanager.service.ICoursereplyService;
import com.coursemanager.service.ILoginService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 下午2:55:49
 */
@Controller
public class CoursereplyController {

	
	private static Logger logger = Logger.getLogger(CoursereplyController.class);    
	@Resource
	private ICoursediscussService  coursediscussService;	
	

	@Resource
	private ICoursereplyService  coursereplyService;	

	@Resource
	private ILoginService  loginService;	
	
	//回复列表
	@RequestMapping(value="/coursereplydetail",method = RequestMethod.GET)
	public ModelAndView  Coursereplydetail(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int coursediscussid = Integer.parseInt(request.getParameter("coursediscussid"));
		logger.info("coursediscussid:"+coursediscussid);
        ModelAndView modelAndView = new ModelAndView();  
        List< Coursereply>  coursereplylist =coursereplyService.getCoursereplyebycoursediscussid(coursediscussid);
        Coursediscuss coursediscuss =coursediscussService.findCoursediscussbyCoursediscussid(coursediscussid);
        modelAndView.addObject("coursereplylist", coursereplylist); 
        modelAndView.addObject("coursediscuss", coursediscuss); 
    	logger.info("coursediscuss:"+coursediscuss.getCoursediscusstitile());
        modelAndView.setViewName("coursereplylist");
        return modelAndView;  
}
	
	
	//添加回复
	@RequestMapping(value="/addcoursereplydetail",method = RequestMethod.GET)
	public ModelAndView  addCoursereplydetail(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		String content =request.getParameter("content");
		String coursediscussid = request.getParameter("coursediscussid");
		User user =(User) request.getSession().getAttribute("user");	
		Coursereply coursereply = new  Coursereply();
		coursereply.setBelongcoursediscussid(coursediscussid);
		coursereply.setReply_content(content);
		coursereply.setReply_date(new Date());
		coursereply.setReplyuser(user.getUser_name());
		coursereplyService.insert(coursereply);
		
		
	     ModelAndView modelAndView = new ModelAndView();  
	        List< Coursereply>  coursereplylist =coursereplyService.getCoursereplyebycoursediscussid(Integer.parseInt(coursediscussid));
	        Coursediscuss coursediscuss =coursediscussService.findCoursediscussbyCoursediscussid(Integer.parseInt(coursediscussid));
	        modelAndView.addObject("coursereplylist", coursereplylist); 
	        modelAndView.addObject("coursediscuss", coursediscuss); 
	    	logger.info("coursediscuss:"+coursediscuss.getCoursediscusstitile());
	        modelAndView.setViewName("coursereplylist");
	        return modelAndView;  
		
	 
}
}
