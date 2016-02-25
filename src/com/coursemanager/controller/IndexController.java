package com.coursemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mxs E-mail:308348194@qq.com
 * @version 创建时间：2016年2月25日 下午10:47:47
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){  
		return "index";
	}
}
