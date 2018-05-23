package com.java.mapper;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.java.pojo.Sal_chance;
import com.java.pojo.Sal_plan;

/**
 * 客户开发计划模块
 * @Description TODO 
 * @author 刘凯
 * @date 2018年5月18日:下午5:24:28
 * @Package com.java.mapper
 * @Project crm
 * @ClassName Sal_planMapper.java
 * @since   JDK1.8
 * @version 1.0
 */
public interface Sal_planMapper {
	/**
	 * 查询客户开发计划中详情
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月21日 : 上午8:56:07
	 * @return Sal_plan 
	 * @throws TODO
	 */
	public List<Sal_plan> selectPlanInfo(Long pla_chc_id);
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
	 * 修改计划项
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月21日 : 上午10:46:10 void 
	 * @throws TODO
	 */
	public void updatePlanByplaId(String pla_todo,Long pla_id);
	/**
	 * 添加计划项
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月21日 : 上午11:22:38
	 * @param pla_date
	 * @param pla_todo void 
	 * @throws TODO
	 */
	public void addPlanById(@Param("pla_date") Date pla_date,@Param("pla_todo") String pla_todo,@Param("pla_chc_id") Long pla_chc_id);
}
