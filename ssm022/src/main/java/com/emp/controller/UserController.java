package com.emp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.entity.User;
import com.emp.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	
	//跳转到未授权页面
	@RequestMapping("/user/unauthorized")
	public String toUnauthorized(){
		return "Unauthorized";
	}
	
	/*注册用户*/
	@RequestMapping("/user/register")
	public String register(User user){
		userService.addUser(user);
		//重定向到登陆页面
		return "redirect:/user/toLogin";
	}
	
	/*跳转到注册页面*/
	@RequestMapping("/user/toRegister")
	public String toRegister(){
		return "Register";
	}
	
	/*跳转到登陆页面*/
	@RequestMapping("/user/toLogin")
	public String toLogin(){
		return "Login";
	}
	
	@RequestMapping("/user/login")
	public String login(User user,
			@RequestParam(value="rememberMe",required=false,defaultValue="0")Integer rememberMe,Model model){
		//获取当前用户
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try{
			
			//判断是否使用记住我
			if(rememberMe==1){
				token.setRememberMe(true);
			}
			
			//为当前用户进行认证，授权
			subject.login(token);
			model.addAttribute("user", user);
			return "redirect:/emp/conditionList";
			
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("msg", "用户名或密码错误！");
			return "Login";
		}
	}

}
