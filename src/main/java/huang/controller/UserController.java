package huang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/User")
public class UserController {

	
    @RequestMapping("/helloUser")
    public ModelAndView helloUser(ModelMap modelMap) {
    	ModelAndView mav = new ModelAndView("index");
    	mav.addObject("1", 1);
        return mav;
    }
    

    
}