package com.coursemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version ����ʱ�䣺2016��2��25�� ����10:47:47
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){  
		return "index";
	}
}
