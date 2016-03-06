package com.coursemanager.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.coursemanager.model.Coursedocument;
import com.coursemanager.model.Coursenotice;
import com.coursemanager.service.ICourseService;
import com.coursemanager.service.ICoursedocumentService;
import com.coursemanager.util.DateHelper;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午3:12:51
 */
@Controller
public class CoursedocumentController {
	
	
	private static Logger logger = Logger.getLogger(CoursedocumentController.class);    

	@Resource
	private ICoursedocumentService  coursedocumentService;	
	
	//课程公告列表
	@RequestMapping(value="/coursedocumentlist",method = RequestMethod.GET)
	public ModelAndView  coursedocumentlist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Coursedocument>  coursedocumentlist =coursedocumentService.getallcoursedocumentbycourseid(courseid);
        List<String> SimpleDateFormatlist = new ArrayList<String>();
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        for (int i = 0; i < coursedocumentlist.size(); i++) {

        	SimpleDateFormatlist.add(format.format(coursedocumentlist.get(i).uploadtime.getTime()));
		}
        modelAndView.addObject("coursedocumentlist", coursedocumentlist); 
        modelAndView.addObject("SimpleDateFormatlist", SimpleDateFormatlist); 
        modelAndView.setViewName("coursedocumentlist");
        
        return modelAndView;  
}
}
