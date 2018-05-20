package com.java.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pojo.Sal_chance;
import com.java.pojo.Sys_user;
import com.java.service.impl.Sal_chanceServiceImpl;
import com.java.service.impl.Sys_userServiceImpl;
import com.java.util.Page;

@Controller
public class PageController {
	@Autowired
	private Sys_userServiceImpl sys_UserServiceImpl;
	@Autowired
	private Sal_chanceServiceImpl sal_chanceServiceImpl;
	
	@RequestMapping("/index")
	public ModelAndView index(Long pageNow,Long pageSize,String usr_name,String usr_role_id,HttpServletRequest request) throws Exception {
		//创建模型和视图对象
		ModelAndView mv = new ModelAndView("users");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("usr_name", usr_name);
		map.put("usr_role_id", usr_role_id);
		Page<Sys_user> page = sys_UserServiceImpl.getPage(map, pageNow, pageSize);
		request.setAttribute("usr_name", usr_name);
		request.setAttribute("usr_role_id", usr_role_id);
		mv.addObject("page",page);
		return mv;
	}
	
	@RequestMapping("/tochance")
	public ModelAndView salpage(Long pageNow,Long pageSize,HttpServletRequest request,String chc_cust_name,String chc_title,String chc_linkman) throws Exception{
		//创建模型视图对象
		ModelAndView mv=new ModelAndView("chance");
		Map<String, Object> map=new HashMap<String,Object>();
		//模糊查询要加入的参数
		map.put("chc_cust_name", chc_cust_name);
		map.put("chc_title", chc_title);
		map.put("chc_linkman", chc_linkman);
		request.setAttribute("chc_cust_name", chc_cust_name);
		request.setAttribute("chc_title", chc_title);
		request.setAttribute("chc_linkman", chc_linkman);
		Page<Sal_chance> page=sal_chanceServiceImpl.getPage(map, pageNow, pageSize);
		mv.addObject("page", page);
		return mv;
	}
	
	@RequestMapping("/toPlan")
	public ModelAndView toplan(Long pageNow,Long pageSize,HttpServletRequest request,String chc_cust_name,String chc_title,String chc_linkman) throws Exception{
		ModelAndView mv=new ModelAndView("plan");
		Map<String, Object> map=new HashMap<String,Object>();
		//模糊查询加入的参数
		map.put("chc_cust_name", chc_cust_name);
		map.put("chc_title", chc_title);
		map.put("chc_linkman", chc_linkman);
		request.setAttribute("chc_cust_name", chc_cust_name);
		request.setAttribute("chc_title", chc_title);
		request.setAttribute("chc_linkman", chc_linkman);
		Page<Sal_chance> page=sal_chanceServiceImpl.getPage(map, pageNow, pageSize);
		mv.addObject("page", page);
		return mv;
	}
	
	
	

}
