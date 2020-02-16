package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringSecurityHelperController {

	@RequestMapping(value="/loginPage")
	public String loginpage() {
	
		return "login";
	}
	
	@RequestMapping(value="/loginFailPage")
	public String loginfailpage(Model model) {
		model.addAttribute("msg", "login attemt is failed");
		model.addAttribute("msg2", "reason:entered invaid cridentials");
		return "login";
	}
	
	@RequestMapping(value="/goToHome")
	public String homePage() {
		return "item";
	}
	
	@RequestMapping(value="/logoutPage")
	public String logoutPage(Model model) {
	model.addAttribute("msg", "your are successfully loged out");
		return "login";
	}
	@RequestMapping(value="/errorPage")
	public String accessDenied(Model model) {
	model.addAttribute("msg", "you haven't have permission to access this page");
		return "item";
	}
}
