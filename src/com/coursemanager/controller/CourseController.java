package com.coursemanager.controller;

import java.io.IOException;
import java.util.Date;
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
import com.coursemanager.model.Coursenotice;
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
        modelAndView.setViewName("coursemain");
        return modelAndView;  
}
	
	
	//选择具体课程
	@RequestMapping(value="/teachcourse",method = RequestMethod.GET)
	public ModelAndView  teachcoursemain(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		String choiceid =request.getParameter("choiceid");
        ModelAndView modelAndView = new ModelAndView();  
        ChoiceCourse choiceCourse =courseService.getdetailcourse(Integer.parseInt(choiceid));
		HttpSession session =request.getSession();
		session.setAttribute("courseid", choiceCourse.getCourseid());
        modelAndView.addObject("choiceCourse", choiceCourse); 
        modelAndView.setViewName("teachcoursemain");
        return modelAndView;  
}
	//课程公告列表
	@RequestMapping(value="/coursenoticelist",method = RequestMethod.GET)
	public ModelAndView  coursenoticelist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		User user =(User) request.getSession().getAttribute("user");		
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Coursenotice>  coursenoticelist =Coursenoticeservice.getallcoursenoticebycourseid(courseid);
        modelAndView.addObject("coursenoticelist", coursenoticelist); 
        request.setAttribute("user", user);
        modelAndView.setViewName("coursenoticelist");
        return modelAndView;  
}
	//添加课程公告
	
	@RequestMapping(value="/addcoursenotice",method = RequestMethod.GET)
	public ModelAndView  addcoursenotice(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		Coursenotice coursenotice = new  Coursenotice();
		coursenotice.setNoticecontext("为了鼓励大家积极参与网络课堂，特别提示大家，访问次数和参与讨论次数最多的前5名期末总成绩加5分。 ");
		coursenotice.setByuser("张老师");
		coursenotice.setCourseid(1);
		coursenotice.setNoticetitle("欢迎各位同学访问我的课程信息");
		Date date = new Date();
		coursenotice.setPushda_date(date);
		coursenotice.setUserid(5);
		Coursenoticeservice.insert(coursenotice);
		
        return null;  
}

	
	//查看课程公告详情
	
	@RequestMapping(value="/coursenotice",method = RequestMethod.GET)
	public ModelAndView  coursenoticedetail(HttpServletRequest request, HttpServletResponse response) throws IOException{	
	    String noticeid =request.getParameter("noticeid");
	    Coursenotice coursenotice = Coursenoticeservice.getdetailnoticebyid(Integer.parseInt(noticeid));
	    ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("coursenotice", coursenotice); 
        modelAndView.setViewName("coursenoticedetail");
        return modelAndView;  
     
}

	
	//查看课程公告详情
	
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
