package huang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {

	@RequestMapping("/login")
    public ModelAndView helloUser(ModelMap modelMap) {
    	ModelAndView mav = new ModelAndView("login");
    	mav.addObject("1", 1);
        return mav;
    }
}
