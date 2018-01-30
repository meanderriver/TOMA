package org.tl.toma.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.spring.springboot.dubbo.ConsumerServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tl.toma.service.ProductService;
import org.tl.toma.usermodel.Usermodel;






@Controller

public class UserController {
	
	@Resource
	private ConsumerServer consumerService;
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String getuserinfor(Model model, HttpServletRequest request) {
		Usermodel user=new Usermodel();
		user= consumerService.clientshow();
		model.addAttribute("Userinfor", user);
		return "Userinfor" ;
		
	}
}
