package com.coursemanager.util;

import java.io.File;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version ����ʱ�䣺2016��3��31�� ����6:01:56  
 */
public class Fileutil {

	   public static float getfilesize(String path)
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
