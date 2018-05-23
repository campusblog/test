package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.pojo.Cst_customer;
import com.java.pojo.Sal_chance;
import com.java.util.Page;

/**
 * 客户管理服务层
 * @Description TODO 
 * @author 刘凯
 * @date 2018年5月22日:上午10:04:37
 * @Package com.java.service.impl
 * @Project crm
 * @ClassName Cst_customerService.java
 * @since   JDK1.8
 * @version 1.0
 */
public interface Cst_customerService {
	/**
	 * 按照id删除
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月22日 : 下午12:04:41
	 * @param cust_no void 
	 * @throws TODO
	 */
	public void deleteCustomerById(Long cust_no);
	/**
	 * 按照id查询客户具体信息
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月22日 : 上午11:13:01
	 * @param cust_no
	 * @return Cst_customer 
	 * @throws TODO
	 */
	public Cst_customer selectCustomerById(Long cust_no);
	/**
	 * 查询
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午2:16:53
	 * @param map
	 * @return List<Sal_chance> 
	 * @throws TODO
	 */
	public List<Cst_customer> selectCustomerInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 分页查询
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午2:14:00
	 * @return
	 * @throws Exception Page<Sal_chance> 
	 * @throws TODO
	 */
	Page<Cst_customer> getPage(Map<String, Object> map,Long pageNow,Long pageSize) throws Exception;
}
