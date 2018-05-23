package com.java.controller;


import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.pojo.Cst_customer;
import com.java.pojo.Sal_chance;
import com.java.pojo.Sct_Service;
import com.java.pojo.Sys_user;
import com.java.service.impl.Cst_customerServiceImpl;
import com.java.service.impl.Sal_chanceServiceImpl;
import com.java.service.impl.Sct_ServiceServiceImpl;
import com.java.service.impl.Sys_userServiceImpl;
import com.java.util.Page;

@Controller
public class PageController {
	@Autowired
	private Sys_userServiceImpl sys_UserServiceImpl;
	@Autowired
	private Sal_chanceServiceImpl sal_chanceServiceImpl;
	@Autowired
	private Cst_customerServiceImpl cst_customerServiceImpl;
	@Autowired
	private Sct_ServiceServiceImpl sct_ServiceServiceImpl;
	
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
	
	/**
	 * 查询所有客户分页页面
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月22日 : 上午9:57:23
	 * @param request
	 * @param cust_name
	 * @param cust_level_label
	 * @param cust_status
	 * @param pageNow
	 * @param pageSize
	 * @return ModelAndView 
	 * @throws Exception 
	 * @throws TODO
	 */
	@RequestMapping("/toCustomer")
	public ModelAndView toCutomer(HttpServletRequest request,String cust_name,String cust_level_label,String cust_status,
			Long pageNow,Long pageSize) throws Exception{
		ModelAndView mv=new ModelAndView("customer");
		Map<String, Object> map=new HashMap<String,Object>();
		//模糊查询加入的参数
		map.put("cust_name", cust_name);
		map.put("cust_level_label", cust_level_label);
		map.put("cust_status", cust_status);
		request.setAttribute("cust_name", cust_name);
		request.setAttribute("cust_level_label", cust_level_label);
		request.setAttribute("cust_status", cust_status);
		Page<Cst_customer> page=cst_customerServiceImpl.getPage(map, pageNow, pageSize);
		mv.addObject("page", page);
		return mv;
	}
	
	/**
	 * 服务分页
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月22日 : 下午5:17:19
	 * @return ModelAndView 
	 * @throws Exception 
	 * @throws TODO
	 */
	@RequestMapping("/toShowService")
	public ModelAndView toShowService(HttpServletRequest request,String svr_cust_name,String svr_title,String svr_type,Date svr_create_date,
			Date svr_create_date1,String svr_result,Long pageNow,Long pageSize) throws Exception{
		ModelAndView mv=new ModelAndView("showService");
		Map<String, Object> map=new HashMap<String,Object>();
		//模糊查询加入的参数
		map.put("svr_cust_name", svr_cust_name);
		map.put("svr_title", svr_title);
		map.put("svr_type", svr_type);
		map.put("svr_create_date", svr_create_date);
		map.put("svr_create_date1", svr_create_date1);
		map.put("svr_result", svr_result);
		request.setAttribute("svr_cust_name", svr_cust_name);
		request.setAttribute("svr_title", svr_title);
		request.setAttribute("svr_type", svr_type);
		request.setAttribute("svr_create_date", svr_create_date);
		request.setAttribute("svr_create_date1", svr_create_date1);
		request.setAttribute("svr_result", svr_result);
		Page<Sct_Service> page=sct_ServiceServiceImpl.getPage(map, pageNow, pageSize);
		mv.addObject("page", page);
		return mv;
	}
	
}
