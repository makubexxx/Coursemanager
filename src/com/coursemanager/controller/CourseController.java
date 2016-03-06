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
import com.coursemanager.service.ICourseService;
import com.coursemanager.service.ICoursedetailService;
import com.coursemanager.service.ICoursenoticeService;
/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��2��26�� ����9:21:59
 */
@Controller
public class CourseController {
	
	
	private static Logger logger = Logger.getLogger(CourseController.class);    
	@Resource
	private ICourseService courseService;	
	@Resource
	private ICoursenoticeService Coursenoticeservice;
	@Resource ICoursedetailService Coursedetailservice;
	
	
	//��ȡȫ���γ�
	@RequestMapping(value="/allcourse",method = RequestMethod.GET)
	public ModelAndView  allcourse(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		String userid =(String) request.getSession().getAttribute("userid");
		logger.info("session userid:"+userid);		
        List<ChoiceCourse> courselist =courseService.getallcoursebyuserid(Integer.parseInt(userid));
        logger.info("course:"+courselist.get(0).getCoursename());
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("courselist", courselist);  
        modelAndView.addObject("choiceedcoursenumber",courselist.size());
        modelAndView.setViewName("choiceedcourselist");  
        return modelAndView;  
}
	//ѡ�����γ�
	@RequestMapping(value="/course",method = RequestMethod.GET)
	public ModelAndView  coursemain(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		String userid =(String) request.getSession().getAttribute("userid");		
		String choiceid =request.getParameter("choiceid");
		logger.info("session userid:"+userid+"choiceid:"+choiceid);
        ModelAndView modelAndView = new ModelAndView();  
        ChoiceCourse choiceCourse =courseService.getdetailcourse(Integer.parseInt(choiceid));
		HttpSession session =request.getSession();
		session.setAttribute("courseid", choiceCourse.getCourseid());
        modelAndView.addObject("choiceCourse", choiceCourse); 
        modelAndView.setViewName("coursemain");
        return modelAndView;  
}
	
	//�γ̹����б�
	@RequestMapping(value="/coursenoticelist",method = RequestMethod.GET)
	public ModelAndView  coursenoticelist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Coursenotice>  coursenoticelist =Coursenoticeservice.getallcoursenoticebycourseid(courseid);
        modelAndView.addObject("coursenoticelist", coursenoticelist); 
        modelAndView.setViewName("coursenoticelist");
        return modelAndView;  
}
	//��ӿγ̹���
	
	@RequestMapping(value="/addcoursenotice",method = RequestMethod.GET)
	public ModelAndView  addcoursenotice(HttpServletRequest request, HttpServletResponse response) throws IOException{	
		Coursenotice coursenotice = new  Coursenotice();
		coursenotice.setNoticecontext("Ϊ�˹�����һ�������������ã��ر���ʾ��ң����ʴ����Ͳ������۴�������ǰ5����ĩ�ܳɼ���5�֡� ");
		coursenotice.setByuser("����ʦ");
		coursenotice.setCourseid(1);
		coursenotice.setNoticetitle("��ӭ��λͬѧ�����ҵĿγ���Ϣ");
		Date date = new Date();
		coursenotice.setPushda_date(date);
		coursenotice.setUserid(5);
		Coursenoticeservice.insert(coursenotice);
		
        return null;  
}

	
	//�鿴�γ̹�������
	
	@RequestMapping(value="/coursenotice",method = RequestMethod.GET)
	public ModelAndView  coursenoticedetail(HttpServletRequest request, HttpServletResponse response) throws IOException{	
	    String noticeid =request.getParameter("noticeid");
	    Coursenotice coursenotice = Coursenoticeservice.getdetailnoticebyid(Integer.parseInt(noticeid));
	    ModelAndView modelAndView = new ModelAndView();  
        modelAndView.addObject("coursenotice", coursenotice); 
        modelAndView.setViewName("coursenoticedetail");
        return modelAndView;  
     
}

	
	//�鿴�γ̹�������
	
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
