package com.drvcorp.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.drvcorp.constant.ViewConstant;
import com.drvcorp.model.UserCredential;

@Controller
public class LoginController {

	public static final Log LOG = LogFactory.getLog(LoginController.class);	
	@GetMapping("/")
	public String redirect(){
		LOG.info("METHOD: redirect() ");
		return "redirect:/"+ViewConstant.LOGIN;
	}
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout){
		LOG.info("METHOD: showLoginForm -- Params : error: "+error+", logout: "+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredential",new UserCredential());
		LOG.info("to login view");
		return ViewConstant.LOGIN;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredential") UserCredential userCredential ){
		LOG.info("METHOD: loginCheck -- Params : "+userCredential.toString());
		if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")){
			LOG.info("to contacts view");
			//return ViewConstant.CONTACTS;
			return "redirect:contact/showcontacts";
		}
		LOG.info("to login?error");
		return "redirect:/"+ViewConstant.LOGIN+"?error";
	}

}
