package com.drvcorp.controller;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.drvcorp.constant.ViewConstant;
import com.drvcorp.model.ContactModel;
import com.drvcorp.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	public static final Log LOG = LogFactory.getLog(ContactController.class);	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService; 
	
	public ContactController() {
		// TODO Auto-generated constructor stub
	}
	
	@PreAuthorize("hasRole('USER_ROLE')")
	@GetMapping("/contactform")
	public String redirectContatForm(@RequestParam(name="id",required=false) int id,Model model){
		ContactModel c = new ContactModel();
		LOG.info("METHOD: redirectContatForm form -- Contact Exist : "+id);
		if(id != 0) {
			c = contactService.findContactModelById(id);
		}		
		model.addAttribute("contactModel", c);
		return ViewConstant.CONTACT_FORM;
	}
	
	@GetMapping("/cancel")
	public String cancel(){
		//return ViewConstant.CONTACTS;
		return "redirect:showcontacts";
	}
	
	@PostMapping("/addcontact")
	public String addcontact(@ModelAttribute(name="contactModel") ContactModel contactModel , Model model){
		LOG.info("METHOD: addcontact -- Params : "+contactModel.toString());				
		if( null != contactService.addContact(contactModel)){
			LOG.info("METHOD: addcontact -- result 1 : ");
			model.addAttribute("result", 1);
		}else{
			LOG.info("METHOD: addcontact -- result 0 : ");
			model.addAttribute("result", 0);
		}
		//return ViewConstant.CONTACTS;
		return "redirect:/contact/showcontacts";
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacs(){
		ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username",user.getUsername());
		mav.addObject("contacts", contactService.listAllContacts());
		LOG.info("METHOD: showContacs -- Params : ");
		return mav;
	}
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id",required=true) int id) {
		contactService.removeContact(id);
		return showContacs();
	}

}
