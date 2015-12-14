package com.noah.manage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.elasticsearch.common.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController extends BaseController{
	
//	@RequestMapping("/login")
//    public Object helloUser(HttpServletRequest request,String username,String password) {
//    	String view ="login";
//    	ModelAndView mav = new ModelAndView(view);
//    	if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
//    		return mav;
//    	}
//    	UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
//        token.setRememberMe(true);
//        System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
//        //获取当前的Subject  
//        Subject currentUser = SecurityUtils.getSubject();  
//        try {  
//            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
//            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
//            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
//            System.out.println("对用户[" + username + "]进行登录验证..验证开始");  
//            currentUser.login(token);  
//            System.out.println("对用户[" + username + "]进行登录验证..验证通过");  
////            view = "index";  
//            return "redirect:/index";  
//        }catch(UnknownAccountException uae){  
//            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");  
////            request.setAttribute("message_login", "未知账户");
//            mav.addObject("message_login", "未知账户");
//        }catch(IncorrectCredentialsException ice){  
//            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
////            request.setAttribute("message_login", "密码不正确");  
//            mav.addObject("message_login", "密码不正确");
//        }catch(LockedAccountException lae){  
//            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
////            request.setAttribute("message_login", "账户已锁定");
//            mav.addObject("message_login", "账户已锁定");
//        }catch(ExcessiveAttemptsException eae){  
//            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");  
////            request.setAttribute("message_login", "用户名或密码错误次数过多");
//            mav.addObject("message_login", "用户名或密码错误次数过多");
//        }catch(AuthenticationException ae){  
//            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
//            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
//            ae.printStackTrace();  
////            request.setAttribute("message_login", "用户名或密码不正确");  
//            mav.addObject("message_login", "用户名或密码不正确");
//        }  
//        //验证是否登录成功  
//        if(currentUser.isAuthenticated()){  
//            System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");  
//        }else{  
//            token.clear();  
//        }  
//        
//        return mav;
//    }
	
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("index");
		return mav; 
	}
	
	/**
	 * 首页的映射
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/")
	public String defaultIndex() throws Exception {
		return super.redirect+"/index";
		
	}
 
	/**
	 * 渲染登录/login的界面展示,如果已经登录,跳转到首页,如果没有登录,就渲染login.html
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public Object login(Model model,HttpServletRequest request) throws Exception {
		//判断用户是否登录
		if(SecurityUtils.getSubject().isAuthenticated()){
			return redirect+"/index";
		}
		ModelAndView mav = new ModelAndView("login");
		return mav; 
	}
		
	/**
	 * 处理登录提交的方法
	 * @param currUser 自动封装当前登录人的 账号,密码,验证码
	 * @param session
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public Object loginPost(HttpSession session,HttpServletRequest request,String username,String password,String rememberme) throws Exception {
		//通过账号和密码获取 UsernamePasswordToken token
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
		if(StringUtils.isNotBlank(rememberme)){
			token.setRememberMe(true);
		}else{
			token.setRememberMe(false);
		}
		
		System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
        //获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject();  
		ModelAndView mav = new ModelAndView("login");
		try {
			//会调用 shiroDbRealm 的认证方法 com.yidu.frame.shiro.ShiroDbRealm.doGetAuthenticationInfo(AuthenticationToken)
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			mav.addObject("message_login", "账号不存在!");
			return mav;
		} catch (IncorrectCredentialsException ice) {
			mav.addObject("message_login", "密码错误!");
			return mav;
		} catch (LockedAccountException lae) {
			mav.addObject("message_login", "账号被锁定!");
			return mav;
		}catch(AuthenticationException ae){  
			//通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
			System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
			ae.printStackTrace();  
			mav.addObject("message_login", "用户名或密码不正确");
			return mav;
		} catch (Exception e) {
			mav.addObject("message_login", "未知错误,请联系管理员.");
			return mav;
		}
		
		//验证是否登录成功  
        if(currentUser.isAuthenticated()){  
            System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");  
        }else{  
            token.clear();  
        }  
		
		return redirect+"/index";
	}
		
	/**
	 * 没有权限
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/unauth")
	public String unauth(Model model) throws Exception {
		if(SecurityUtils.getSubject().isAuthenticated()==false){
			return redirect+"/login";
		}
		return "/unauth";
		
	}
		
	/**
	 * logout
	 * @param request
	 */
	@RequestMapping(value="/logout")
    public String logout(HttpServletRequest request){
		Subject currentUser = getSubject();
        if (currentUser == null)
            return redirect+"/login";

        // Log the user out and kill their session if possible.
        currentUser.logout();
        Session session = currentUser.getSession(false);
        if (session == null){
        	return redirect+"/login";
        }
        session.stop();
        return redirect+"/login";
    }
	
	private Subject getSubject(){
	    Subject currentUser = ThreadContext.getSubject();// SecurityUtils.getSubject();
	    if (currentUser == null){
	        currentUser = SecurityUtils.getSubject();
	    }
	    return currentUser;
	}
}
