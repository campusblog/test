package com.java.controller;

import java.io.Writer;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.pojo.Sal_chance;
import com.java.pojo.Sal_plan;
import com.java.service.impl.Sal_chanceServiceImpl;
import com.java.service.impl.Sal_planServiceImpl;

@Controller
public class Sal_planController {
	
	@Autowired
	private Sal_planServiceImpl sal_planServiceImpl;
	@Autowired
	private Sal_chanceServiceImpl sal_chanceServiceImpl;
	/**
	 * 跳转计划详情
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月21日 : 上午9:06:29
	 * @param request
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping("/toPlanInfo")
	public String toPlanInfo(HttpServletRequest request,Long chc_id){
		Sal_chance sal_chance=sal_chanceServiceImpl.selectCnanceInfo(chc_id);
		List<Sal_plan> sal_plan=sal_planServiceImpl.selectPlanInfo(chc_id);
		request.setAttribute("sal_chance", sal_chance);
		request.setAttribute("sal_plan", sal_plan);
		return "planformulate";
	}
	
	/**
	 * 跳转添加计划页面将部分数据传输到页面
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月21日 : 上午10:06:15
	 * @param request
	 * @param chc_id
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping("/toPlanformulate")
	public String toPlanformulate(HttpServletRequest request,Long chc_id){
		Sal_chance sal_chance=sal_chanceServiceImpl.selectCnanceInfo(chc_id);
		List<Sal_plan> sal_plan=sal_planServiceImpl.selectPlanInfo(chc_id);
		request.setAttribute("sal_chance", sal_chance);
		request.setAttribute("sal_plan", sal_plan);
		return "planformulate";
	}
	
	/**
	 * 添加后进行处理然后页面跳转显示
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月21日 : 上午10:08:06
	 * @param request
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping("/doPlanformulate")
	public String doPlanformulate(HttpServletRequest request,String pla_todo,Long pla_id){
		//调用业务层方法
		sal_planServiceImpl.updatePlanByplaId(pla_todo, pla_id);
		//最后跳转
		return "redirect:/toPlanInfo";
	}
	
	/**
	 * ajax修改计划项，依然重定向到当前页面查询
	 * @Description TODO
	 * @author 刘凯
	 * @date 2018年5月21日 : 上午11:06:23
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping("updatePlanByplaId")
	public String updatePlanByplaId(String pla_todo,Long chc_id, Long pla_id){
		sal_planServiceImpl.updatePlanByplaId(pla_todo, pla_id);
		return "redirect:/toPlanformulate?chc_id="+chc_id;
	}
	
	/**
	 * 添加计划项,依然重定向到当前页面查询
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月21日 : 上午11:30:34
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping("/addPlanById")
	public String addPlanById(HttpServletRequest request,Date pla_date,String pla_todo,Long chc_id, Long pla_chc_id){
		sal_planServiceImpl.addPlanById(pla_date,pla_todo,pla_chc_id);
		return "redirect:/toPlanformulate?chc_id="+chc_id;
	}
	
}
