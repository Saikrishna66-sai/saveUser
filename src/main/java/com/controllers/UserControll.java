package com.controllers;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.userpojo.Test;
import com.validation.UserService;

@Controller
public class UserControll {
	
	final static Logger logger=Logger.getLogger(UserControll.class);
	
	@Autowired
	UserService vail;
	
	@RequestMapping(value="/new")
	public String saveUser(Test test,Model m) {
		
		String save = vail.saveUser(test, m);
		
		return save;
	}
	@RequestMapping(value="/file")
	public String loginUser(@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,Model m/*,HttpSession httpsession*/) {
		
		String login = vail.loginUser(/*httpsession, */email,password,m);
		
		return login;
	}
	@RequestMapping(value="/userList")
	public String userList(Model m/*,HttpSession httpsession*/) {
		String userList = vail.userList(m/*,httpsession*/);
		logger.info("user list is successfully showen");
		return userList;
	}
	@RequestMapping(value="/deleteUser" )
	public String deleteUser(@RequestParam(value="userform") String id,Model m/*,HttpSession httpsession*/) {
		String user = vail.deleteUser(id,m/*,httpsession*/);
		return user;
	}
	
	@RequestMapping(value="/logout")
	public String logout(Model m,HttpSession httpsession) {
		httpsession.removeAttribute("email");
		m.addAttribute("msg", "your account is successfully logedout please enter your credentials to login");
		return "login";
	}
}
