package com.java.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.java.pojo.Sal_chance;
import com.java.pojo.Sys_user;
import com.java.service.impl.Sal_chanceServiceImpl;

@Controller
public class Sal_chanceController {
	@Autowired
	private Sal_chanceServiceImpl sal_chanceServiceImpl;
	
	public Sal_chanceServiceImpl getSal_chanceServiceImpl() {
		return sal_chanceServiceImpl;
	}

	public void setSal_chanceServiceImpl(Sal_chanceServiceImpl sal_chanceServiceImpl) {
		this.sal_chanceServiceImpl = sal_chanceServiceImpl;
	}

	/**
	 * 查看具体销售机会详情
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月19日 : 上午10:44:48
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping("/toChanceassign")
	public String toChanceassign (HttpServletRequest request,Long chc_id){
		Sal_chance sal_chance=sal_chanceServiceImpl.selectCnanceInfo(chc_id);
		request.setAttribute("sal_chance", sal_chance);
		return "chanceassign";
	}
	
	/**
	 * 修改前跳转到修改页面顺便将部分数据传入到修改页面
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月19日 : 下午1:56:12
	 * @param request
	 * @param chc_id
	 * @return String
	 * @throws TODO
	 */
	@RequestMapping("/toUpdateChance")
	public String toUpdateChance(HttpServletRequest request,Long chc_id){
		Sal_chance sal_chance=sal_chanceServiceImpl.selectCnanceInfo(chc_id);
		request.setAttribute("sal_chance", sal_chance);
		return "updatechance";
	}
	
	//实现ajax下拉
	@RequestMapping(value="getSys_user",produces={"application/json;charset=UTF-8"},method=RequestMethod.POST)
	@ResponseBody
	public String getSys_user(HttpServletResponse response){
	        //防止乱码  
	        response.setCharacterEncoding("UTF-8");
	        List<Sys_user> sys_users=sal_chanceServiceImpl.selectPerson();
	       return JSON.toJSONString(sys_users);
	}
	
	@RequestMapping("/doUpdateChance")
	public String doUpdateChance(Long chc_due_id,Date chc_due_date){
		sal_chanceServiceImpl.updateChance(chc_due_id, chc_due_date);
		//页面跳转到显示所有
		return "tochance";
	}
}
