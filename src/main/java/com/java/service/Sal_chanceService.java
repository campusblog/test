package com.java.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java.pojo.Sal_chance;
import com.java.pojo.Sys_user;
import com.java.util.Page;

public interface Sal_chanceService {
	/**
	 * 修改销售机会
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月19日 : 下午2:27:48 void 
	 * @throws TODO
	 */
	public void updateChance(Long chc_due_id,Date chc_due_date);
	/**
	 * 查看具体
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月19日 : 上午10:50:28
	 * @param chc_id
	 * @return Sal_chance 
	 * @throws TODO
	 */
	public Sal_chance selectCnanceInfo(Long chc_id);
	/**
	 * 查询指派人
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午3:40:51
	 * @return String 
	 * @throws TODO
	 */
	public List<Sys_user> selectPerson();
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
