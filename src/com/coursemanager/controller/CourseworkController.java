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
 * @version ����ʱ�䣺2016��3��6�� ����5:00:36
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
	//��������ҵ�б�
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

	//��ҵ�б��ύ����ҳ��
	@RequestMapping(value="/courseworkdetail",method = RequestMethod.GET)
	public ModelAndView  courseworkdetail(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		String courseworkid = request.getParameter("courseworkid");
		 User user =(User) request.getSession().getAttribute("user");
		logger.info("courseworkid:"+courseworkid);
        ModelAndView modelAndView = new ModelAndView();  
        Coursework Coursework =courseworkService.getCourseworkbyCourseworkid(Integer.parseInt(courseworkid));
        Courseworkupload  courseworkupload = courseworkuploadService.findbyid(Integer.valueOf(courseworkid), Integer.valueOf(user.getUserid()+""));
        modelAndView.addObject("Coursework", Coursework); 
        //��ʦ��������ʾ �ύѧ���б�
        if(user.getUser_type()==10)
        {
        	
        }
        //ѧ��
        else {
        	  //˵���Ѿ��ύ����ҵ �����������ύ��ť  ��ʾ�ύ����
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
	
	//��ҵ�ύ
	@RequestMapping("/coursework/upload"  )  
    public ModelAndView upload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
	     String fileName=null;
	     int result=0;
	     String courseworkid = request.getParameter("courseworkid");
	     User user =(User) request.getSession().getAttribute("user");
	     String content =  request.getParameter("content");
       //����һ��ͨ�õĶಿ�ֽ�����  
       CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
       //�ж� request �Ƿ����ļ��ϴ�,���ಿ������  
       if(multipartResolver.isMultipart(request)){  
           //ת���ɶಿ��request    
           MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
           //ȡ��request�е������ļ���  
           Iterator<String> iter = multiRequest.getFileNames();  
           //
           while(iter.hasNext()){  
               //��¼�ϴ�������ʼʱ��ʱ�䣬���������ϴ�ʱ��  
               int pre = (int) System.currentTimeMillis();  
               //ȡ���ϴ��ļ�  
               MultipartFile file = multiRequest.getFile(iter.next());  
               if(file != null){  
                   //ȡ�õ�ǰ�ϴ��ļ����ļ�����  
                   String myFileName = file.getOriginalFilename();  
                   //������Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������  
                   if(myFileName.trim() !=""){  
                       System.out.println(myFileName);  
                       //�������ϴ�����ļ���  
                        fileName =  file.getOriginalFilename();  
                       //�����ϴ�·��  
                       String path = "D:/Coursemanager/" + fileName;  
                       File localFile = new File(path);  
                       file.transferTo(localFile);  
                   }  
                   
                   File uploadfile=new File("D:\\Coursemanager\\"+fileName);
                   
                   //����ļ����� ��˵���ϴ��ɹ�
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
               //û���ϴ�����
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
    
       //����ɹ�����ֵ
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
	
	//��������ҵ
	
	//��ӽ�ѧ��Դ
	@RequestMapping(value="/addcoursework",method = RequestMethod.POST)
	public void  addcoursework(HttpServletRequest request, HttpServletResponse response) throws IOException{			
	
        HashMap<String, Object>  map =new  HashMap<String, Object>();
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		   //����  
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
