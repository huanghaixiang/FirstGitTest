package huang.controller;

import org.elasticsearch.common.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import huang.idao.IUserDAO;
import huang.service.IUserService;
import huang.service.UserService;

@Controller
public class UserController {

	@Inject private IUserService userService ;
    @Inject private UserService uservice;
    @Inject private IUserDAO userDAO ;

    @RequestMapping("/User/helloUser")
    public ModelAndView helloUser(ModelMap modelMap) {
    	if(null == userService){
    		System.out.println(1);
    	}
    	if(null == uservice){
    		System.out.println(2);
    	}
    	if(null == userDAO){
    		System.out.println(3);
    	}
//        List<UserDo> list = userService.findAllUser();
//        modelMap.addAttribute("userDo", list) ;
    	ModelAndView mav = new ModelAndView("user_list");
        return mav;
    }
}