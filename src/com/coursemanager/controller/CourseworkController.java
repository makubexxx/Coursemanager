package com.coursemanager.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javafx.scene.input.DataFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.Coursedocument;
import com.coursemanager.model.Coursework;
import com.coursemanager.model.Courseworkupload;
import com.coursemanager.model.Teachresource;
import com.coursemanager.model.User;
import com.coursemanager.service.ICourseworkService;
import com.coursemanager.service.ICourseworkuploadService;
import com.coursemanager.util.DateHelper;
import com.coursemanager.util.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月6日 下午5:00:36
 * 
 */
@Controller
public class CourseworkController {
	

	private static Logger logger = Logger.getLogger(CourseworkController.class);  
	
	@Resource
	private ICourseworkService courseworkService;	
	@Resource
	private ICourseworkuploadService courseworkuploadService;
	
	public static Gson gsonBuilderWithExpose = new GsonBuilder()
	.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	//发布的作业列表
	@RequestMapping(value="/courseworklist",method = RequestMethod.GET)
	public ModelAndView  courseworklist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		String courseid = request.getParameter("courseid");
		User user =(User) request.getSession().getAttribute("user");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Coursework>  courseworklist =courseworkService.getCourseworkbycourseid(courseid);
        modelAndView.addObject("courseworklist", courseworklist); 
        if(user.getUser_type()==10)
        {
            modelAndView.setViewName("teacher/courseworklist");    
        }
        else {
            modelAndView.setViewName("student/courseworklist");    
		}
       
        return modelAndView;  
}

	//作业列表提交详情页面
	@RequestMapping(value="/courseworkdetail",method = RequestMethod.GET)
	public ModelAndView  courseworkdetail(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		String courseworkid = request.getParameter("courseworkid");
		 User user =(User) request.getSession().getAttribute("user");
		logger.info("courseworkid:"+courseworkid);
        ModelAndView modelAndView = new ModelAndView();  
        Coursework Coursework =courseworkService.getCourseworkbyCourseworkid(Integer.parseInt(courseworkid));
        Courseworkupload  courseworkupload = courseworkuploadService.findbyid(Integer.valueOf(courseworkid), Integer.valueOf(user.getUserid()+""));
        modelAndView.addObject("Coursework", Coursework); 
        //老师进入是显示 提交学生列表
        if(user.getUser_type()==10)
        {
        	
        }
        //学生
        else {
        	  //说明已经提交过作业 。。。隐藏提交按钮  显示提交内容
            if(courseworkupload!=null)
            {modelAndView.addObject("courseworkupload", courseworkupload); 
            modelAndView.setViewName("student/hassubmitcourseworkdetail");    
            }
            else {
            	 modelAndView.setViewName("student/courseworkdetail"); 
    		}
		}
     
       
        return modelAndView;  
}
	
	//作业提交
	@RequestMapping("/coursework/upload"  )  
    public ModelAndView upload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
	     String fileName=null;
	     int result=0;
	     String courseworkid = request.getParameter("courseworkid");
	     User user =(User) request.getSession().getAttribute("user");
	     String content =  request.getParameter("content");
       //创建一个通用的多部分解析器  
       CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
       //判断 request 是否有文件上传,即多部分请求  
       if(multipartResolver.isMultipart(request)){  
           //转换成多部分request    
           MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
           //取得request中的所有文件名  
           Iterator<String> iter = multiRequest.getFileNames();  
           //
           while(iter.hasNext()){  
               //记录上传过程起始时的时间，用来计算上传时间  
               int pre = (int) System.currentTimeMillis();  
               //取得上传文件  
               MultipartFile file = multiRequest.getFile(iter.next());  
               if(file != null){  
                   //取得当前上传文件的文件名称  
                   String myFileName = file.getOriginalFilename();  
                   //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                   if(myFileName.trim() !=""){  
                       System.out.println(myFileName);  
                       //重命名上传后的文件名  
                        fileName =  file.getOriginalFilename();  
                       //定义上传路径  
                       String path = "D:/Coursemanager/" + fileName;  
                       File localFile = new File(path);  
                       file.transferTo(localFile);  
                   }  
                   
                   File uploadfile=new File("D:\\Coursemanager\\"+fileName);
                   
                   //如果文件存在 则说明上传成功
                   if(uploadfile.exists())
                   {
                	   Courseworkupload courseworkupload =new  Courseworkupload();
                	   courseworkupload.setContent(content);
                	   courseworkupload.setUserid(Integer.valueOf(user.getUserid()+""));
                	   courseworkupload.setCourseworkid(Integer.valueOf(courseworkid));
                	   courseworkupload.setAttachment("\\CourseManager\\file\\download?fileName="+fileName);
                	   result =courseworkuploadService.insert(courseworkupload);
                   }
               }  
               //没有上传附件
               else {
				
            	   Courseworkupload courseworkupload =new  Courseworkupload();
            	   courseworkupload.setContent(content);
            	   courseworkupload.setUserid(Integer.valueOf(user.getUserid()+""));
            	   courseworkupload.setCourseworkid(Integer.valueOf(courseworkid));
            	   courseworkupload.setAttachment(null);
            	   result =courseworkuploadService.insert(courseworkupload);
			}
               
           }  
             
       }  
    
       //插入成功返回值
       if(result==1)
       {
           ModelAndView modelAndView = new ModelAndView();  
           modelAndView.setViewName("successed");    
           return modelAndView;  
       }
       else {
    	   
    	   ModelAndView modelAndView = new ModelAndView();  
           modelAndView.setViewName("error");    
           return modelAndView;  
		
	}
		

    }  
	
	//发布新作业
	
	//添加教学资源
	@RequestMapping(value="/addcoursework",method = RequestMethod.POST)
	public void  addcoursework(HttpServletRequest request, HttpServletResponse response) throws IOException{			
	
        HashMap<String, Object>  map =new  HashMap<String, Object>();
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		   //解码  
      String str = URLDecoder.decode(request.getParameter("postdata"),"UTF-8");
 	  JSONObject json = JSONObject.fromObject(str);
	  String title=json.getString("title");
	  String content=json.getString("content");
	  String startdate=json.getString("startdate");
	  String enddate=json.getString("enddate");
	  logger.info("courseid:"+courseid+"--title:"+title+"--startdate:"+startdate+"--enddate:"+enddate);
	  
	  Coursework coursework = new Coursework();
	  coursework.setBelongcourseid(courseid+"");
	  coursework.setCourseworktitle(title);	
	  coursework.setEnd_date(DateHelper.getStringtoDate(startdate));
	  coursework.setEnd_date(DateHelper.getStringtoDate(enddate));
	  int result =courseworkService.insert(coursework);

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
