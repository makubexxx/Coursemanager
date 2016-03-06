package com.coursemanager.controller;

import java.io.IOException;
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
import com.coursemanager.service.ICoursediscussService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��6�� ����1:10:41
 */
@Controller
public class CoursediscussController {
	
	
	
	private static Logger logger = Logger.getLogger(CoursediscussController.class);    

	@Resource
	private ICoursediscussService  coursediscussService;	
	
	//�γ̹����б�
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
	
	//�γ̹����б�
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

}
