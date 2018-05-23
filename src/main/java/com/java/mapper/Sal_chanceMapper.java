package com.java.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java.pojo.Sal_chance;
import com.java.pojo.Sys_user;

/**
 * 销售机会管理
 * 
 * @Description TODO
 * @author 刘凯
 * @date 2018年5月18日:上午11:29:42
 * @Package com.java.mapper
 * @Project crm
 * @ClassName Sal_chanceMapper.java
 * @since JDK1.8
 * @version 1.0
 */
public interface Sal_chanceMapper {
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
	 * 修改销售机会
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月19日 : 下午2:27:48 void 
	 * @throws TODO
	 */
	public void updateChance(Long chc_due_id,Date chc_due_date);
	
	/**
	 * 查询总销售机会条数信息
	 * 
	 * @Description TODO
	 * @author 刘凯
	 * @date 2018年5月18日 : 上午11:30:39
	 * @return Long
	 * @throws TODO
	 */
	public Long getCount(Map<String, Object> map) throws Exception;
	/**
	 * 查询所有销售机会
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 上午11:33:57
	 * @param map
	 * @return
	 * @throws Exception List<Sal_chance> 
	 * @throws TODO
	 */
	public List<Sal_chance> select(Map<String, Object> map) throws Exception;
}
