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
 * @version ����ʱ�䣺2016��3��5�� ����3:12:51
 */
@Controller
public class CoursedocumentController {
	
	
	private static Logger logger = Logger.getLogger(CoursedocumentController.class);    

	@Resource
	private ICoursedocumentService  coursedocumentService;	
	
	//�γ��ļ�ҳ��
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
	
	//��ʦ�ϴ��γ��ļ�
	@RequestMapping(value="/Coursedocument/upload" , method = RequestMethod.POST)  
    public ModelAndView upload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
	     String fileName=null;
	     int courseid =   (Integer) request.getSession().getAttribute("courseid");
	     String description =  request.getParameter("description");
	     String titile =request.getParameter("titile");
	     logger.info("description:"+description+"---"+"title:"+titile);
   	     ModelAndView modelAndView = new ModelAndView();  
        //����һ��ͨ�õĶಿ�ֽ�����  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //�ж� request �Ƿ����ļ��ϴ�,���ಿ������  
        if(multipartResolver.isMultipart(request)){  
            //ת���ɶಿ��request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //ȡ��request�е������ļ���  
            Iterator<String> iter = multiRequest.getFileNames();  
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
                }  
                //��¼�ϴ����ļ����ʱ��  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);  
            }  
              
        }  
        File file=new File("D:\\Coursemanager\\"+fileName);
        
        //����ļ����� ��˵���ϴ��ɹ�
        if(file.exists())
        {
            //�����ϴ���¼
       	 Coursedocument coursedocument = new  Coursedocument();
       	 coursedocument.setBelongcourseid(courseid);
       	 coursedocument.setCoursedocumenttitile(titile);
       	 coursedocument.setCoursedocument_description(description);
       	 Date date = new Date();
       	 coursedocument.setUploadtime(date);
       	 coursedocument.setDoucumenturl(fileName);
       	 int result =coursedocumentService.insert(coursedocument);
       	 //����ɹ�
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
	
	//�μ�����
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
	 
	             // ������Ҫ�رա�
	            os.close();
	 
	            inputStream.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	            //  ����ֵҪע�⣬Ҫ��Ȼ�ͳ�������������
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
