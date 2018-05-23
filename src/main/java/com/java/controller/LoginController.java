package com.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.pojo.Sys_role;
import com.java.pojo.Sys_user;
import com.java.service.impl.Sys_userServiceImpl;

@Controller
@RequestMapping("/Sys_user")
public class LoginController{
	
	@Autowired
	private Sys_userServiceImpl sys_UserServiceImpl;
	
	public Sys_userServiceImpl getSys_UserServiceImpl() {
		return sys_UserServiceImpl;
	}

	public void setSys_UserServiceImpl(Sys_userServiceImpl sys_UserServiceImpl) {
		this.sys_UserServiceImpl = sys_UserServiceImpl;
	}
	
	@RequestMapping(value = "check", method = RequestMethod.POST)
	public ModelAndView checkUser(@RequestParam String username,@RequestParam String password,HttpServletRequest request,HttpServletResponse response,
			RedirectAttributes attr){
		List<Sys_role> list=sys_UserServiceImpl.selectRolesInfo();
		//String url="redirect:/toadmin?username&list"+username+list;
	int count = sys_UserServiceImpl.checkUser(username, password);
		if (count>0) {
			//如果没有问题直接跳转到用户信息主页面
//			attr.addFlashAttribute("username", username);
//			attr.addFlashAttribute("list", list);
		request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("list", list);
			ModelAndView modelAndView=new ModelAndView("redirect:/toadmin");
			return modelAndView;
		}
		//账户和密码有问题重定向到登录页面
		ModelAndView modelAndView=new ModelAndView("redirect:/tologin");
		return modelAndView;
	}
	
	@RequestMapping("/delete")
	public String delete(String usr_id,HttpServletRequest request){
		//进行删除
		
		return "redirect:/index";
	}
	
	/**
	 * 在跳转修改前将个人信息转发到页面
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 上午11:17:49
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping("/userassign")
	public String userassign(){
		
		
		return "userassign";
	}
	
	@RequestMapping("/insertUser")
	public String insertUser(Sys_user sys_user,HttpServletRequest request){
		Sys_user sys_user2=new Sys_user();
		sys_user2.setUsr_name(sys_user.getUsr_name());
		sys_user2.setUsr_password(sys_user.getUsr_password());
		sys_UserServiceImpl.insertUser(sys_user2);
		//重定向到显示页面
		return "redirect:/index";
	}
}
