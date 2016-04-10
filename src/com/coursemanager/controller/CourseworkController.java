package com.coursemanager.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.ChoiceCourse;
import com.coursemanager.model.Coursenotice;
import com.coursemanager.model.Coursework;
import com.coursemanager.model.Courseworkupload;
import com.coursemanager.model.User;
import com.coursemanager.model.Workuploaduser;
import com.coursemanager.service.ICourseService;
import com.coursemanager.service.ICourseworkService;
import com.coursemanager.service.ICourseworkuploadService;
import com.coursemanager.service.IUserService;
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
	
	@Resource
	private ICourseService courseService;
	
	@Resource
	
	private IUserService userService;
	
	public static Gson gsonBuilderWithExpose = new GsonBuilder()
	.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	//��������ҵ�б�
	@RequestMapping(value="/courseworklist",method = RequestMethod.GET)
	public ModelAndView  courseworklist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		String courseid = request.getParameter("courseid");
		User user =(User) request.getSession().getAttribute("user");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Coursework>  courseworklist =courseworkService.getCourseworkbycourseid(courseid);
        for (int i = 0; i < courseworklist.size(); i++) {
			
        	Date tempdate1 =courseworklist.get(i).getStart_date();
        	Date tempdate2 =courseworklist.get(i).getEnd_date();
        	courseworklist.get(i).setStartdate(format2.format(tempdate1));
        	courseworklist.get(i).setEnddate(format2.format(tempdate2));
		}
        
        modelAndView.addObject("courseworklist", courseworklist); 
        if(user.getUser_type()==10)
        {
            modelAndView.setViewName("teacher/courseworklist");    
        }
        //ѧ������ʾ�Ƿ��ύ������ҵ
        else {
        	
   
        	
        	for (int i = 0; i < courseworklist.size(); i++) {
				Courseworkupload tempcourseworkupload =courseworkuploadService.findbyid(Integer.valueOf(courseworklist.get(i).getCourseworkid()),Integer.valueOf(user.getUserid()+""));
				//û����ҵ
				if(tempcourseworkupload==null)
				{
					courseworklist.get(i).setStatue("δ�ύ");
				}
				else {
					courseworklist.get(i).setStatue("�Ѿ��ύ");
				}
			}
            modelAndView.setViewName("student/courseworklist");    
		}
       
        return modelAndView;  
}

	//��ҵ�б��ύ����ҳ��
	@RequestMapping(value="/courseworkdetail",method = RequestMethod.GET)
	public ModelAndView  courseworkdetail(HttpServletRequest request, HttpServletResponse response) throws IOException{		
		
		String courseworkid = request.getParameter("courseworkid");
		 User user =(User) request.getSession().getAttribute("user");
		 int courseid = (Integer) request.getSession().getAttribute("courseid");
	     HttpSession session =request.getSession();
		session.setAttribute("courseworkid", courseworkid);
		logger.info("courseworkid:"+courseworkid);
        ModelAndView modelAndView = new ModelAndView();  
        Coursework Coursework =courseworkService.getCourseworkbyCourseworkid(Integer.parseInt(courseworkid));
        Courseworkupload  courseworkupload = courseworkuploadService.findbyid(Integer.valueOf(courseworkid), Integer.valueOf(user.getUserid()+""));
        modelAndView.addObject("Coursework", Coursework); 
        //��ʦ��������ʾ �ύѧ���б�
        if(user.getUser_type()==10)
        {
        	
        	//��ѯѡ�α�  �г� ѡ���ÿγ̵�ȫ��ѧ��
        	List <ChoiceCourse>  choiceuserlist=courseService.getchoiceCoursebyCourseid(Long.valueOf(courseid+""));
        	List<Workuploaduser> hasreadcommituserlist = new  ArrayList<Workuploaduser>();  //�Ѿ��ύ��ҵ�����Ѿ���ֵ��û�����
        	List<User> notreadcommituserlist = new  ArrayList<User>(); //�Ѿ��ύ��ҵ ��δ��ֵ��б�
        	List<User> notcommituserlist = new  ArrayList<User>(); //û���ύ��ҵ���û�����
         	for (int i = 0; i < choiceuserlist.size(); i++) {
				

        		//����ȫ��userid
        		User tempUser =userService.finduserbyid(choiceuserlist.get(i).getUserid());
        		if(tempUser.getUser_type()!=10)
        		{
        			  Courseworkupload  tempcourseworkupload = courseworkuploadService.findbyid(Integer.valueOf(courseworkid), Integer.valueOf(tempUser.getUserid()+""));
            
        			  if(tempcourseworkupload==null)
        			  {
        				  notcommituserlist.add(tempUser);
        			  }
        			  else {
        				  //�����Ѿ�����б�
        				  if(tempcourseworkupload.getScore()!=null)
        				  {
        					 Workuploaduser tempWorkuploaduser =new Workuploaduser();
        					 tempWorkuploaduser.setUser(tempUser);
        					 tempWorkuploaduser.setScore(tempcourseworkupload.getScore());
        					 hasreadcommituserlist.add(tempWorkuploaduser);
        				  }
        				  else {
        					  notreadcommituserlist.add(tempUser);
						}
					}
        		}
			}
         
        
         	 modelAndView.addObject("hasreadcommituserlist", hasreadcommituserlist); 
         	 modelAndView.addObject("notreadcommituserlist", notreadcommituserlist); 
         	 modelAndView.addObject("notcommituserlist", notcommituserlist); 
        	 modelAndView.setViewName("teacher/courseworkuploadlist"); 
        	
        	
        }
        //ѧ��
        else {
        	  //˵���Ѿ��ύ����ҵ �����������ύ��ť  ��ʾ�ύ����
            if(courseworkupload!=null)
            {
            
            modelAndView.addObject("courseworkupload", courseworkupload); 
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
	public void  addcoursework(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{			
	
        HashMap<String, Object>  map =new  HashMap<String, Object>();
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		   //����  
      String str = URLDecoder.decode(request.getParameter("postdata"),"UTF-8");
 	  JSONObject json = JSONObject.fromObject(str);
	  String title=json.getString("title");
	  String content=json.getString("content");

	  String startdate=json.getString("startdate");
	 startdate= startdate.replaceAll("T"," ");
	  String enddate=json.getString("enddate");
	  enddate= enddate.replaceAll("T"," ");
	  Date sDate =format1.parse(startdate);
	  Date eDate =format1.parse(enddate);
	  logger.info("courseid:"+courseid+"--title:"+title+"--startdate:"+sDate+"--enddate:"+eDate);
	  
	  Coursework coursework = new Coursework();
	  coursework.setBelongcourseid(courseid+"");
	  coursework.setCourseworktitle(title);	
	  coursework.setCoursework_content(content);
	  coursework.setStart_date(sDate);
	  coursework.setEnd_date(eDate);
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

	
	   //����鿴��ҵ���ҳ��
		@RequestMapping(value="/scorecourseworkdetail",method = RequestMethod.GET)
		public ModelAndView scorecourseworkdetail(HttpServletRequest request, HttpServletResponse response) throws IOException{		
			
			String courseworkid = (String) request.getSession().getAttribute("courseworkid");
			String userid =request.getParameter("userid");
			logger.info("scorecourseworkdetail  courseworkid:"+courseworkid);
	        ModelAndView modelAndView = new ModelAndView();  
	        User user = userService.finduserbyid(Long.valueOf(userid));
	        Workuploaduser workuploaduser = new  Workuploaduser();
	        workuploaduser.setUser(user);
	        
	        Coursework Coursework =courseworkService.getCourseworkbyCourseworkid(Integer.parseInt(courseworkid));
	        Courseworkupload  courseworkupload = courseworkuploadService.findbyid(Integer.valueOf(courseworkid), Integer.valueOf(userid));
	        modelAndView.addObject("Coursework", Coursework); 
	        	  //˵���Ѿ��ύ����ҵ �����������ύ��ť  ��ʾ�ύ����
	            if(courseworkupload!=null)
	            {
	            modelAndView.addObject("courseworkupload", courseworkupload); 
	            workuploaduser.setScore(courseworkupload.getScore());
	            logger.info("score:"+courseworkupload.getScore());
	            modelAndView.addObject("workuploaduser", workuploaduser); 
	            modelAndView.setViewName("teacher/scorecourseworkupload");    
	            }
	       
	        return modelAndView;  
	}

		

		//�޸ķ���
		
		@RequestMapping(value="/updatescore",method = RequestMethod.GET)
		public void  updatescore(HttpServletRequest request, HttpServletResponse response) throws IOException{	
			String courseworkid = (String) request.getSession().getAttribute("courseworkid");
			String userid =request.getParameter("userid");
			String score =request.getParameter("score");
			logger.info("courseworkid:"+courseworkid+"userid:"+userid+"score"+score);
			int result = courseworkuploadService.update(Integer.valueOf(courseworkid), Integer.valueOf(userid), score);
		    logger.info("result"+result);
		    Map<String, Object> map = new HashMap<String, Object>();
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
