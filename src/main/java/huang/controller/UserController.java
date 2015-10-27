package huang.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import huang.model.UserDo;
import huang.service.IUserService;
import huang.util.search.ElasticSearchUtil;

@Controller
@RequestMapping("/User")
public class UserController {

	@Inject private IUserService userService ;

    @RequestMapping("/helloUser")
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
    
    
    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(HttpServletRequest request,UserDo ud){
    	int affect_count = userService.addUser(ud.getUserno(),ud.getPassword());
		if(1==affect_count){    //新增成功，创建索引
			ElasticSearchUtil.index("users", "users", ud);
		}
    	return affect_count==1?"success":"failure";
    }
    @RequestMapping("/searchUser")
    public ModelAndView searchUser(HttpServletRequest request,String keyword){
    	List<UserDo> list = ElasticSearchUtil.search("users", "users", keyword);
    	ModelAndView mav = new ModelAndView("user_list");
    	mav.addObject("userList",list);
        return mav;
    }
    
}