package com.java.dao.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dao.Sal_planDao;
import com.java.mapper.Sal_planMapper;
import com.java.pojo.Sal_plan;

@Repository
public class Sal_planDaoImpl implements Sal_planDao {

	@Autowired
	private Sal_planMapper sal_planMapper;
	
	@Override
	public List<Sal_plan> selectPlanInfo(Long pla_chc_id) {
		// TODO 自动生成的方法存根
		return sal_planMapper.selectPlanInfo(pla_chc_id);
	}

	@Override
	public void updatePlanByplaId(String pla_todo, Long pla_id) {
		// TODO 自动生成的方法存根
		sal_planMapper.updatePlanByplaId(pla_todo, pla_id);
	}

	@Override
	public void addPlanById(Date pla_date, String pla_todo,Long pla_chc_id) {
		// TODO 自动生成的方法存根
		sal_planMapper.addPlanById(pla_date, pla_todo,pla_chc_id);
	}

}
