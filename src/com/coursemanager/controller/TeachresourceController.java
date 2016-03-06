package com.coursemanager.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.Coursedocument;
import com.coursemanager.model.Teachresource;
import com.coursemanager.service.ITeachresourceService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午10:13:50
 */
@Controller
public class TeachresourceController {

	
	private static Logger logger = Logger.getLogger(TeachresourceController.class);    

	@Resource
	private ITeachresourceService  teachresourceService;	
	
	//教学资源列表
	@RequestMapping(value="/teachresourcelist",method = RequestMethod.GET)
	public ModelAndView  teachresourcelist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Teachresource>  teachresourcelist =teachresourceService.getteachresourcebycourseid(courseid);
        modelAndView.addObject("teachresourcelist", teachresourcelist); 
        modelAndView.setViewName("teachresourcelist");
        
        return modelAndView;  
}
}
