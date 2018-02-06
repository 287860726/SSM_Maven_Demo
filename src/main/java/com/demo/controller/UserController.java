package com.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.codehaus.jackson.map.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.biz.UserBiz;
import com.demo.entity.User;

@Controller
@RequestMapping("/UserController")
public class UserController {

	@Autowired
	private UserBiz userbiz;

	@RequestMapping("/getAllUser")
	public String getAllUser(ModelMap mm) {
		List<User> users = null;
		try {
			users = userbiz.getAllUser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		mm.addAttribute("users", users);
		return "test";
	}
}
