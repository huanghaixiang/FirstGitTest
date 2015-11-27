package huang.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class LoginController {

	@RequestMapping("/login")
    public ModelAndView helloUser(ModelMap modelMap) {
    	ModelAndView mav = new ModelAndView("login");
    	System.out.println("123");
    	mav.addObject("1", 1);
        return mav;
    }
}
