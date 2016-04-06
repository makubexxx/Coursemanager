package com.coursemanager.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.Coursenotice;
import com.coursemanager.model.User;
import com.coursemanager.service.ICoursenoticeService;
import com.coursemanager.util.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version 创建时间：2016年3月31日 下午3:49:04  
 */
@Controller
public class CoursenoticeController {

	private static Logger logger = Logger.getLogger(CoursenoticeController.class);
	@Resource
	private ICoursenoticeService Coursenoticeservice;
	
	public static Gson gsonBuilderWithExpose = new GsonBuilder()
	.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	//课程公告页面
		@RequestMapping(value="/coursenoticelist",method = RequestMethod.GET)
		public ModelAndView  coursenoticelist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
			int courseid = (Integer) request.getSession().getAttribute("courseid");
			User user =(User) request.getSession().getAttribute("user");		
	        ModelAndView modelAndView = new ModelAndView();  
	        List<Coursenotice>  coursenoticelist =Coursenoticeservice.getallcoursenoticebycourseid(courseid);
	        modelAndView.addObject("coursenoticelist", coursenoticelist); 
	        logger.info("usertype:"+user.getUser_type());
	
	        if(user.getUser_type()!=10)
		{
	        	modelAndView.setViewName("student/coursenoticelist");
		}
	        else {
	        	modelAndView.setViewName("teacher/coursenoticelist");
			}
	        return modelAndView;  
	}

	
	//添加课程公告
	
	@RequestMapping(value="/addcoursenotice",method = RequestMethod.GET)
	public void  addcoursenotice(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		String content =request.getParameter("content");
		String title =request.getParameter("title");
		User user =(User) request.getSession().getAttribute("user");
        Map<String, Object> map = new HashMap<String, Object>();
		if(user.getUser_type()!=10)
		{
			map.put("statue", 1);
		}
		else{
			Coursenotice coursenotice = new  Coursenotice();
			coursenotice.setNoticecontext(content);
			coursenotice.setByuser(user.getUser_name()+"老师");
			coursenotice.setCourseid(courseid);
			coursenotice.setNoticetitle(title);
			Date date = new Date();
			coursenotice.setPushda_date(date);
			coursenotice.setUserid(5);
			int result =Coursenoticeservice.insert(coursenotice);
			if(result!=0)
			{
				map.put("statue", 0);
			}
			else {

				map.put("statue", 1);
			}
		}
		
	     Response.response(gsonBuilderWithExpose.toJson(map),response);

}

	//课程公告详情
	
	@RequestMapping(value="/coursenotice",method = RequestMethod.GET)
	public ModelAndView  coursenoticedetail(HttpServletRequest request, HttpServletResponse response) throws IOException{	
	    String noticeid =request.getParameter("noticeid");
	    Coursenotice coursenotice = Coursenoticeservice.getdetailnoticebyid(Integer.parseInt(noticeid));
	    ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("coursenotice", coursenotice); 
        modelAndView.setViewName("coursenoticedetail");
        return modelAndView;  
     
}
}
