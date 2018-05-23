package com.java.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.pojo.Sal_plan;
public interface Sal_planService {
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
