package com.coursemanager.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.Teachresource;
import com.coursemanager.model.User;
import com.coursemanager.service.ITeachresourceService;
import com.coursemanager.util.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午10:13:50
 */
@Controller
public class TeachresourceController {

	
	private static Logger logger = Logger.getLogger(TeachresourceController.class);    

	@Resource
	private ITeachresourceService  teachresourceService;	
	
	public static Gson gsonBuilderWithExpose = new GsonBuilder()
	.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	//教学资源列表
	@RequestMapping(value="/teachresourcelist",method = RequestMethod.GET)
	public ModelAndView  teachresourcelist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		User user =(User) request.getSession().getAttribute("user");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Teachresource>  teachresourcelist =teachresourceService.getteachresourcebycourseid(courseid);
        modelAndView.addObject("teachresourcelist", teachresourcelist); 
        if(user.getUser_type()==10)
        {
            modelAndView.setViewName("teacher/teachresourcelist");
        }

        else {
            modelAndView.setViewName("student/teachresourcelist");
		}
        return modelAndView;  
}
	
	//添加教学资源
	@RequestMapping(value="/addteachresource",method = RequestMethod.POST)
	public void  addteachresource(HttpServletRequest request, HttpServletResponse response) throws IOException{			
	
        HashMap<String, Object>  map =new  HashMap<String, Object>();
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		   //解码  
      String str = URLDecoder.decode(request.getParameter("postdata"),"UTF-8");
 	  JSONObject json = JSONObject.fromObject(str);
	  String title=json.getString("title");
	  String link=json.getString("link");
	  String description=json.getString("description");
	  logger.info("courseid:"+courseid+"--title:"+title+"--link:"+link+"--descprion:"+description);
	  Teachresource teachresource = new  Teachresource();
	  teachresource.setBelongcourseid(courseid+"");
	  teachresource.setLinkurl(link);
	  teachresource.setLinkname(title);
	  teachresource.setTeachresourcedescription(description);
	  int result =teachresourceService.insert(teachresource);
	  if(result==1)
	  {
		  map.put("statue", 0);
	  }
	  else {

		  map.put("statue", 1);
	}
	  Response.response(gsonBuilderWithExpose.toJson(map), response);
}
}
