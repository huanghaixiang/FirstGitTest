package huang.controller;


import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import huang.mapper.UserMapper;
import huang.model.UserBean;
import huang.service.IUserService;
import huang.util.StringUtil;
import huang.util.search.ElasticSearchUtil;

@Controller
@RequestMapping("/User")
public class UserController {

	@Inject private IUserService userService ;
	
	@Inject private UserMapper userMapper ;
	
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
    public String addUser(HttpServletRequest request,UserBean ud){
//    	int affect_count = userService.addUser(ud.getUserno(),ud.getPassword());
    	System.out.println(" user_id之前 : "+ ud.getId());
    	int id = userMapper.insertSelective(ud);
    	System.out.println(" user_id之后 : "+ ud.getId());
		if(id>0){    //新增成功，创建索引
			//去数据库查询，找id
			ElasticSearchUtil.index("users", "users", userMapper.selectByPrimaryKey(ud.getId()));
		}
		
    	return id>0?"success":"failure";
    }
    
    @RequestMapping("/searchUser")
    public ModelAndView searchUser(HttpServletRequest request,String keyword){
    	if(StringUtil.isEmpty(keyword)) keyword = "*:*";
    	List<UserBean> list = ElasticSearchUtil.search("users", "users", keyword);
    	ModelAndView mav = new ModelAndView("user_list");
    	mav.addObject("userList",list);
        return mav;
    }
    
}