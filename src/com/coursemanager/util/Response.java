package com.coursemanager.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/** 
 * @author mxs 
 * @E-mail:308348194@qq.com 
 * @version ����ʱ�䣺2016��3��31�� ����2:03:57  
 */
public class Response {

	public static void response(String Json,HttpServletResponse response)
	{
		try {
			//�����ݷ���
			response.setCharacterEncoding("UTF-8");
			response.flushBuffer();
			response.getWriter().write(Json);
			response.getWriter().flush();  
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
