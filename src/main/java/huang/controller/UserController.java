package huang.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import huang.service.IUserService;

@Controller
public class UserController {

	@Inject private IUserService userService ;

    @RequestMapping("/User/helloUser")
    public ModelAndView helloUser(ModelMap modelMap) {
    	if(null == userService){
    		System.out.println(1);
    	}else{
    		System.out.println("list size : "+userService.findAllUser().size() );
    	}
    	//TODO
    	
//      List<UserDo> list = userService.findAllUser();
//      modelMap.addAttribute("userDo", list) ;
    	ModelAndView mav = new ModelAndView("user_list");
    	mav.addObject("userList",userService.findAllUser());
        return mav;
    }
}