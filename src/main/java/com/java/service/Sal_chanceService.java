package com.java.service;

import java.util.List;
import java.util.Map;

import com.java.pojo.Sal_chance;
import com.java.util.Page;

public interface Sal_chanceService {

	/**
	 * 查询指派人
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午3:40:51
	 * @return String 
	 * @throws TODO
	 */
	public String selectPerson();
	/**
	 * 查询
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午2:16:53
	 * @param map
	 * @return List<Sal_chance> 
	 * @throws TODO
	 */
	public List<Sal_chance> selectChanceInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 分页查询
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午2:14:00
	 * @return
	 * @throws Exception Page<Sal_chance> 
	 * @throws TODO
	 */
	Page<Sal_chance> getPage(Map<String, Object> map,Long pageNow,Long pageSize) throws Exception;
}
