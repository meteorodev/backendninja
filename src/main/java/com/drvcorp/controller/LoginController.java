package com.drvcorp.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.drvcorp.constant.ViewConstant;

@Controller
public class LoginController {

	public static final Log LOG = LogFactory.getLog(LoginController.class);	
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout){
		LOG.info("METHOD: showLoginForm -- Params : error: "+error+", logout: "+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("to login view");
		return ViewConstant.LOGIN;
	}
	
	@GetMapping({"loginsuccess", "/"})
	public String loginCheck(){
		LOG.info("METHOD: loginCheck -- Params : ");
		LOG.info("REturning to contacts view ");
		return "redirect:contact/showcontacts";
		
	}
	

}
