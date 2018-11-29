package com.bcs.tja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("test")
public class TestController {
	
	//用户登录日志详情
		@RequestMapping("e1")
		public ModelAndView getLogInLogDetail(String p1,ModelMap modelMap) {
			System.out.println(p1);
			
			return new ModelAndView("index");
		}
}