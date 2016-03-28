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

import com.coursemanager.model.Coursework;
import com.coursemanager.service.ICourseworkService;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��3��6�� ����5:00:36
 */
@Controller
public class CourseworkController {
	

	private static Logger logger = Logger.getLogger(CourseworkController.class);  
	
	@Resource
	private ICourseworkService courseworkService;	
	
	//��ҵ�б�
	@RequestMapping(value="/courseworklist",method = RequestMethod.GET)
	public ModelAndView  courseworklist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		String courseid = request.getParameter("courseid");
		String userid =(String) request.getSession().getAttribute("userid");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Coursework>  courseworklist =courseworkService.getCourseworkbycourseid(courseid, Integer.parseInt(userid));
        for (int i = 0; i < courseworklist.size(); i++) {
        	logger.info("courseworklist:"+courseworklist.get(i).getCourseworktitle());
			
        	if(courseworklist.get(i).getStatue()==0)
        	{
        		courseworklist.get(i).setStatuedescrpition("δ�ύ");;
        	}
        	else {
        		courseworklist.get(i).setStatuedescrpition("�Ѿ��ύ");;
			}
		}
        modelAndView.addObject("courseworklist", courseworklist); 
        modelAndView.setViewName("courseworklist");    
        return modelAndView;  
}

	//��ҵ�б�
	@RequestMapping(value="/courseworkdetail",method = RequestMethod.GET)
	public ModelAndView  courseworkdetail(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		String courseworkid = request.getParameter("courseworkid");
		logger.info("courseworkid:"+courseworkid);
        ModelAndView modelAndView = new ModelAndView();  
        Coursework Coursework =courseworkService.getCourseworkbyCourseworkid(Integer.parseInt(courseworkid));
        modelAndView.addObject("Coursework", Coursework); 
        modelAndView.setViewName("courseworkdetail");    
        return modelAndView;  
}

}
