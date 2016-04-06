package com.coursemanager.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.coursemanager.service.ICourseworkService;
import com.coursemanager.util.Fileutil;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version ����ʱ�䣺2016��2��25�� ����1:08:23  
 */
@Controller
@RequestMapping("/file")  
public class FileController {
	@Resource
	private ICourseworkService courseworkService;	

	@RequestMapping("/upload"  )  
    public String upload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
	     String fileName=null;
	    String courseworkid = request.getParameter("courseworkid");
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
        
        return "/successed";  
    }  
	
	   @RequestMapping("/download")
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
	   

}
