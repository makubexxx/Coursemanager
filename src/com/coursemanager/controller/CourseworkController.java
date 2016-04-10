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
	
	@Resource
	private ICourseService courseService;
	
	@Resource
	
	private IUserService userService;
	
	public static Gson gsonBuilderWithExpose = new GsonBuilder()
	.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	//发布的作业列表
	@RequestMapping(value="/courseworklist",method = RequestMethod.GET)
	public ModelAndView  courseworklist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		String courseid = request.getParameter("courseid");
		User user =(User) request.getSession().getAttribute("user");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
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
        //学生。显示是否提交过该作业
        else {
        	
   
        	
        	for (int i = 0; i < courseworklist.size(); i++) {
				Courseworkupload tempcourseworkupload =courseworkuploadService.findbyid(Integer.valueOf(courseworklist.get(i).getCourseworkid()),Integer.valueOf(user.getUserid()+""));
				//没交作业
				if(tempcourseworkupload==null)
				{
					courseworklist.get(i).setStatue("未提交");
				}
				else {
					courseworklist.get(i).setStatue("已经提交");
				}
			}
            modelAndView.setViewName("student/courseworklist");    
		}
       
        return modelAndView;  
}

	//作业列表提交详情页面
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
        //老师进入是显示 提交学生列表
        if(user.getUser_type()==10)
        {
        	
        	//查询选课表  列出 选过该课程的全部学生
        	List <ChoiceCourse>  choiceuserlist=courseService.getchoiceCoursebyCourseid(Long.valueOf(courseid+""));
        	List<Workuploaduser> hasreadcommituserlist = new  ArrayList<Workuploaduser>();  //已经提交作业并且已经打分的用户集合
        	List<User> notreadcommituserlist = new  ArrayList<User>(); //已经提交作业 还未打分的列表
        	List<User> notcommituserlist = new  ArrayList<User>(); //没有提交作业的用户集合
         	for (int i = 0; i < choiceuserlist.size(); i++) {
				

        		//遍历全部userid
        		User tempUser =userService.finduserbyid(choiceuserlist.get(i).getUserid());
        		if(tempUser.getUser_type()!=10)
        		{
        			  Courseworkupload  tempcourseworkupload = courseworkuploadService.findbyid(Integer.valueOf(courseworkid), Integer.valueOf(tempUser.getUserid()+""));
            
        			  if(tempcourseworkupload==null)
        			  {
        				  notcommituserlist.add(tempUser);
        			  }
        			  else {
        				  //加入已经打分列表
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
        //学生
        else {
        	  //说明已经提交过作业 。。。隐藏提交按钮  显示提交内容
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
	public void  addcoursework(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{			
	
        HashMap<String, Object>  map =new  HashMap<String, Object>();
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		   //解码  
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

	
	   //教书查看作业打分页面
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
	        	  //说明已经提交过作业 。。。隐藏提交按钮  显示提交内容
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

		

		//修改分数
		
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
