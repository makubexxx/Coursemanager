package com.coursemanager.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
import com.coursemanager.util.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��6�� ����1:10:41
 */
@Controller
public class CoursediscussController {
	
	
	
	private static Logger logger = Logger.getLogger(CoursediscussController.class);    

	@Resource
	private ICoursediscussService  coursediscussService;	
	
	
	public static Gson gsonBuilderWithExpose = new GsonBuilder()
	.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
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

	//�����������
	@RequestMapping(value="/addcoursediscuss",method = RequestMethod.GET)
	public void  addcoursediscuss(HttpServletRequest request, HttpServletResponse response) throws IOException{			
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
        int result=coursediscussService.addCoursediscuss(coursediscuss);
        logger.info("insert result"+result);
        HashMap<String, Object> map =new HashMap<String, Object>();
        if(result!=0)
        {
          	map.put("statue", 0);
        }
   
        else {
        	map.put("statue", 1);
		}
       Response.response(gsonBuilderWithExpose.toJson(map),response);
}
}
