package com.coursemanager.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.coursemanager.model.Coursedocument;
import com.coursemanager.model.Coursenotice;
import com.coursemanager.model.User;
import com.coursemanager.service.ICourseService;
import com.coursemanager.service.ICoursedocumentService;
import com.coursemanager.util.DateHelper;
import com.coursemanager.util.Fileutil;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年3月5日 下午3:12:51
 */
@Controller
public class CoursedocumentController {
	
	
	private static Logger logger = Logger.getLogger(CoursedocumentController.class);    

	@Resource
	private ICoursedocumentService  coursedocumentService;	
	
	//课程文件页面
	@RequestMapping(value="/coursedocumentlist",method = RequestMethod.GET)
	public ModelAndView  coursedocumentlist(HttpServletRequest request, HttpServletResponse response) throws IOException{			
		int courseid = (Integer) request.getSession().getAttribute("courseid");
		User user = (User) request.getSession().getAttribute("user");
		logger.info("courseid:"+courseid);
        ModelAndView modelAndView = new ModelAndView();  
        List<Coursedocument>  coursedocumentlist =coursedocumentService.getallcoursedocumentbycourseid(courseid);
        modelAndView.addObject("coursedocumentlist", coursedocumentlist); 
        if(user.getUser_type()==10)
        {
        	 modelAndView.setViewName("teacher/coursedocumentlist");
        }
        else {
        	 modelAndView.setViewName("student/coursedocumentlist");
		}
       
        return modelAndView;  
}
	
	//教师上传课程文件
	@RequestMapping(value="/Coursedocument/upload" , method = RequestMethod.POST)  
    public ModelAndView upload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
	     String fileName=null;
	     int courseid =   (Integer) request.getSession().getAttribute("courseid");
	     String description =  request.getParameter("description");
	     String titile =request.getParameter("titile");
	     logger.info("description:"+description+"---"+"title:"+titile);
   	     ModelAndView modelAndView = new ModelAndView();  
        //创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
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
                }  
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);  
            }  
              
        }  
        File file=new File("D:\\Coursemanager\\"+fileName);
        
        //如果文件存在 则说明上传成功
        if(file.exists())
        {
            //保存上传记录
       	 Coursedocument coursedocument = new  Coursedocument();
       	 coursedocument.setBelongcourseid(courseid);
       	 coursedocument.setCoursedocumenttitile(titile);
       	 coursedocument.setCoursedocument_description(description);
       	 Date date = new Date();
       	 coursedocument.setUploadtime(date);
       	 coursedocument.setDoucumenturl(fileName);
       	 int result =coursedocumentService.insert(coursedocument);
       	 //插入成功
       	 if(result==1)
       	 {
       	   	 modelAndView.setViewName("successed");
       	 }
    else {
    	modelAndView.setViewName("error");
	}

        }
         else {
       	  modelAndView.setViewName("error");
    
        	 }
         
         return modelAndView;  
		

        
      
    } 
	
	//课件下载
	  @RequestMapping("/Coursedocument/download")
	    public String download(String fileName, HttpServletRequest request,
	            HttpServletResponse response) {
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("multipart/form-data");
	        response.setHeader("Content-Disposition", "attachment;fileName="
	                + fileName);
	        try {
	        	 String path = "D:/Coursemanager";  
	            InputStream inputStream = new FileInputStream(new File(path
	                    + File.separator + fileName));
	 
	            OutputStream os = response.getOutputStream();
	            byte[] b = new byte[2048];
	            int length;
	            while ((length = inputStream.read(b)) > 0) {
	                os.write(b, 0, length);
	            }
	 
	             // 这里主要关闭。
	            os.close();
	 
	            inputStream.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	            //  返回值要注意，要不然就出现下面这句错误！
	            //java+getOutputStream() has already been called for this response
	        return null;
	    }
	   
	   public float getfilesize(String path)
	   {
		   float size = 0;
		    File f= new File(path);  
		    if (f.exists() && f.isFile()){  
		        size=(f.length()/(1024*1024));
		    }else{  
		    }  
		return size;
		   
	   }
}
