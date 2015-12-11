package com.noah.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/switch")
public class SwitchController {
	
	@RequestMapping("/index")
	public ModelAndView switchIndex(){
		ModelAndView mav = new ModelAndView("switch");
		return mav;
	}
}
