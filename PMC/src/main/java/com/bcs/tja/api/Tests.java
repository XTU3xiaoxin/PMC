package com.bcs.tja.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcs.tja.service.UserService;


@RestController
@RequestMapping("api/test")
public class Tests {

	@Autowired
	private UserService userService;
	
		@RequestMapping("e1")
		public Map<String,Object> getLogInLogDetail(User u,ModelMap modelMap) {
			System.out.println(u.getP1());
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("status",200);
			data.put("msg", "success");
			data.put("data", u);
			
			return data;
		}
		
		@RequestMapping("e2")
		public Map<String,Object> getUserInfo(Integer id) {
			System.out.println(id);
			Map<String,Object> data = new HashMap<String,Object>();
			com.bcs.tja.domain.User u = userService.findById(id);
			
			data.put("status",200);
			data.put("msg", "success");
			data.put("data", u);
			
			return data;
		}
		
		@RequestMapping("e3")
		public Map<String,Object> getUserInfoByName(String name) {
			System.out.println(name);
			Map<String,Object> data = new HashMap<String,Object>();
			com.bcs.tja.domain.User u = userService.findByName(name);
			
			data.put("status",200);
			data.put("msg", "success");
			data.put("data", u);
			
			return data;
		}
}