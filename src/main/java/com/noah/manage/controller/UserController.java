package com.noah.manage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.noah.manage.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired UserService userService;
	
    @RequestMapping("/userList")
    public ModelAndView helloUser(ModelMap modelMap) { 
    	ModelAndView mav = new ModelAndView("temp"); //userList
    	mav.addObject("userList", userService.getAllUsers()); 
        return mav;
    }
    

    
}