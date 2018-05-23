package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.pojo.Cst_customer;
import com.java.pojo.Sct_Service;
import com.java.util.Page;

public interface Sct_ServiceService {
	/**
	 * 查询
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午2:16:53
	 * @param map
	 * @return List<Sal_chance> 
	 * @throws TODO
	 */
	public List<Sct_Service> selectCustomerInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 分页查询
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午2:14:00
	 * @return
	 * @throws Exception Page<Sal_chance> 
	 * @throws TODO
	 */
	Page<Sct_Service> getPage(Map<String, Object> map,Long pageNow,Long pageSize) throws Exception;
}
