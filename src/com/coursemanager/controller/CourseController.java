package com.coursemanager.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.ChoiceCourse;
import com.coursemanager.model.Coursedetail;
import com.coursemanager.model.User;
import com.coursemanager.service.ICourseService;
import com.coursemanager.service.ICoursedetailService;
import com.coursemanager.service.ICoursenoticeService;
/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月26日 下午9:21:59
 */
@Controller
public class CourseController {
	
	
	private static Logger logger = Logger.getLogger(CourseController.class);    
	@Resource
	private ICourseService courseService;	
	@Resource
	private ICoursenoticeService Coursenoticeservice;
	@Resource ICoursedetailService Coursedetailservice;
	
	
	//获取全部课程
	@RequestMapping(value="/allcourse",method = RequestMethod.GET)
	public ModelAndView  allcourse(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		User user =(User) request.getSession().getAttribute("user");
        List<ChoiceCourse> courselist =courseService.getallcoursebyuserid(user.getUserid());
        logger.info("course:"+courselist.get(0).getCoursename());
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("courselist", courselist);  
        modelAndView.addObject("choiceedcoursenumber",courselist.size());
        modelAndView.setViewName("choiceedcourselist");  
        return modelAndView;  
}
	
	
	//获取该老师授课列表
	@RequestMapping(value="/teachcourselist",method = RequestMethod.GET)
	public ModelAndView  teachcourselist(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		User user =(User) request.getSession().getAttribute("user");	
        List<ChoiceCourse> courselist =courseService.getallcoursebyuserid(user.getUserid());
        logger.info("course:"+courselist.get(0).getCoursename());
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("courselist", courselist);  
        modelAndView.addObject("choiceedcoursenumber",courselist.size());
        modelAndView.setViewName("teachcourselist");  
        return modelAndView;  
}
	//选择具体课程
	@RequestMapping(value="/course",method = RequestMethod.GET)
	public ModelAndView  coursemain(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		User user =(User) request.getSession().getAttribute("user");		
		String choiceid =request.getParameter("choiceid");
        ModelAndView modelAndView = new ModelAndView();  
        ChoiceCourse choiceCourse =courseService.getdetailcourse(Integer.parseInt(choiceid));
		HttpSession session =request.getSession();
		session.setAttribute("courseid", choiceCourse.getCourseid());
        modelAndView.addObject("choiceCourse", choiceCourse); 
        modelAndView.addObject("user", user); 
        if(user.getUser_type()==10)
        {
            modelAndView.setViewName("teacher/coursemain");
        }

        else {
            modelAndView.setViewName("student/coursemain");
		}
        return modelAndView;  
}
	
	
	
	//查看课程详情
	
	@RequestMapping(value="/coursedetail",method = RequestMethod.GET)
	public ModelAndView  coursedetail(HttpServletRequest request, HttpServletResponse response) throws IOException{	
	    String courseid =request.getParameter("courseid");
        Coursedetail coursedetail = Coursedetailservice.getcoursedetailbyid(Integer.parseInt(courseid));
	    ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("coursedetail", coursedetail); 
        modelAndView.setViewName("coursedetail");
        return modelAndView;  
}
	
	


	

}
