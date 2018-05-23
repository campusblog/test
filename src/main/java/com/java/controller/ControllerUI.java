package com.java.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.pojo.Sys_user;

/**
 * 方便访问页面跳转的UICOntroller
 * 
 * @Description TODO
 * @author 刘凯
 * @date 2018年5月15日:上午11:01:23
 * @Package com.java.controller
 * @Project crm
 * @ClassName ControllerUI.java
 * @since JDK1.8
 * @version 1.0
 */
@Controller
public class ControllerUI {
	@RequestMapping("/tologin")
	public String toLogin() {
		return "login";
	}

	// 跳转显示主页
	@RequestMapping("/toadmin")
	public String toAdmin() {
		return "admin";
	}

/*	// 跳转销售机会管理
	@RequestMapping("/toChance")
	public String toChance() {
		return "chance";
	}

	// 跳转客户开发计划
	@RequestMapping("/toPlan")
	public String toPlan() {
		return "plan";
	}

	// 跳转用户管理
	@RequestMapping("/toUsers")
	public String toUser() {
		return "users";
	}*/
	
	@RequestMapping("/toChancemanage")
	public String toChancemanage(){
		return "chancemanage";
	}
	// 跳转显示中间模块
	@RequestMapping("/toRoles")
	public String toRoles(HttpServletRequest request) {
		return "roles";
	}

	@RequestMapping(value = "/toUserinsert", method = RequestMethod.GET)
	public String toUserinsert() {
		return "userinsert";
	}
	
	/**
	 * 在跳转修改前将个人信息转发到页面
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 上午11:17:49
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping(value="/userassign", method = RequestMethod.GET)
	public String userassign(){
		
		System.out.println("修改");
		return "userassign";
	}
}
