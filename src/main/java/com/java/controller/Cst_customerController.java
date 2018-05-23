package com.java.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.pojo.Cst_customer;
import com.java.service.impl.Cst_customerServiceImpl;

/**
 * 客户管理模块控制层
 * @Description TODO 
 * @author 刘凯
 * @date 2018年5月22日:上午11:15:37
 * @Package com.java.controller
 * @Project crm
 * @ClassName Cst_customerController.java
 * @since   JDK1.8
 * @version 1.0
 */
@Controller
public class Cst_customerController {

	@Autowired
	private Cst_customerServiceImpl cst_customerServiceImpl;
	
	/**
	 * 找到具体客户信息跳转
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月22日 : 上午11:19:07
	 * @param request
	 * @param cust_no
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping("/toCustomerInfo")
	public String toCustomerInfo(HttpServletRequest request 
			,Long cust_no){
		Cst_customer cst_customer=cst_customerServiceImpl.selectCustomerById(cust_no);
		request.setAttribute("cst_customer", cst_customer);
		return "customerassign";
	}
	
	/**
	 * 删除客户
	 * @Description TODO
	 * @author 刘凯
	 * @date 2018年5月22日 : 下午12:11:27
	 * @param request
	 * @param cust_no
	 * @return String 
	 * @throws TODO
	 */
	@RequestMapping("/doDelete")
	public String doDelet(HttpServletRequest request,Long cust_no){
		cst_customerServiceImpl.deleteCustomerById(cust_no);
		return "redirect:/toCustomer";
	}
}
