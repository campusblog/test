package com.java.dao;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.java.pojo.Sal_plan;

/**
 * 客户开发计划
 * @Description TODO 
 * @author 刘凯
 * @date 2018年5月19日:上午9:00:03
 * @Package com.java.dao
 * @Project crm
 * @ClassName Sal_plan.java
 * @since   JDK1.8
 * @version 1.0
 */
public interface Sal_planDao {
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
	public void addPlanById(Date pla_date,String pla_todo,Long pla_chc_id);
}
