package com.java.dao;

import java.util.List;
import java.util.Map;

import com.java.pojo.Cst_customer;

/**
 * 客户管理dao层
 * @Description TODO 
 * @author 刘凯
 * @date 2018年5月22日:上午10:00:23
 * @Package com.java.dao
 * @Project crm
 * @ClassName Cst_customer.java
 * @since   JDK1.8
 * @version 1.0
 */
public interface Cst_customerDao {
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
	 * 查询总客户条数信息
	 * 
	 * @Description TODO
	 * @author 刘凯
	 * @date 2018年5月18日 : 上午11:30:39
	 * @return Long
	 * @throws TODO
	 */
	public Long getCount(Map<String, Object> map) throws Exception;
	/**
	 * 查询所有客户
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 上午11:33:57
	 * @param map
	 * @return
	 * @throws Exception List<Sal_chance> 
	 * @throws TODO
	 */
	public List<Cst_customer> select(Map<String, Object> map) throws Exception;
}
