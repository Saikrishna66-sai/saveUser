package com.validation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.database.hibernate.UserDao;
import com.userpojo.Itempo;
import com.userpojo.Test;

import saveInterface.IUserDaoInterface;



public class UserService {
	
	final static Logger logger=Logger.getLogger(UserService.class);
	@Autowired
	IUserDaoInterface dao;
	
	public String saveUser(Test test,Model m) {
		
		System.out.println("entered into mobile validation");
		boolean validation = validation(test.getMobile());
		System.out.println("validation completed");
		if (!validation) {
			System.out.println("not vaild");
			m.addAttribute("msg", "you entered invalid mobile number");
			logger.debug("user entered invaild mobile number");
			return "register";
		}
		
		dao.saveUser(test);
		logger.info("user entered vaild mobile number and successfully logedin");
		
		m.addAttribute("msg", "your registration is successfully completed");
		
		return "register";
		
	}
	public boolean validation(String mobile) {

		Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}");

		Matcher m = p.matcher(mobile);

		return m.matches();

	}
	public String loginUser(/*HttpSession httpsession, */String email,String password,Model m) {
		
		List<Test> list = dao.loginUser(email,password);
		
		/*httpsession.setAttribute("email", email);*/
		if(list.isEmpty()) {
			m.addAttribute("msg", "you entred invalid userName and password");
			logger.debug("user is failed to login");
			return "login";
		}
			m.addAttribute("loged", "you are successfully logedin");
			logger.debug("user is successfully logedin");
		return "item";
	}

	public String userList(Model m/*,HttpSession httpsession*/) {

		/*String email = (String) httpsession.getAttribute("email");
		
		if(email==null || email.isEmpty()) {
			m.addAttribute("msg", "please login first");
			return "login";
		}*/
		 List<Test> userList = dao.userList();
		 m.addAttribute("mg", userList);
		 logger.info("list is successfully showen");
		 return "userlist";
	}
	
	public String deleteUser(String id,Model m/*,HttpSession httpsession*/) {
		
		int res = dao.deleteUser(id);
		List<Test> userList = dao.userList();
		
		/*String email = (String) httpsession.getAttribute("email");
		
		if(email==null || email.isEmpty()) {
			m.addAttribute("msg", "please login first");
			return "login";
		}*/
		
		
		if(res==1) {
			String message= id + "user is successfully deleted";
			m.addAttribute("message",message);
			m.addAttribute("mg", userList);
			logger.debug("user is successfully deleted");
			return "userlist";
		}else {
			
			String message= id + "user is not deleted please try again";
			m.addAttribute("message", message);
			m.addAttribute("mg", userList);
			logger.warn("user is not deleted please delete again");
			return "userlist";
		}
	}
	}
