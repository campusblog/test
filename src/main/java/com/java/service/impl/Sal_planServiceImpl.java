package com.java.service.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.Sal_planDao;
import com.java.pojo.Sal_plan;
import com.java.service.Sal_planService;
@Service
@Transactional
public class Sal_planServiceImpl implements Sal_planService {
	@Autowired
	private Sal_planDao sal_planDao;
	
	@Override
	public List<Sal_plan> selectPlanInfo(Long pla_chc_id) {
		// TODO 自动生成的方法存根
		return sal_planDao.selectPlanInfo(pla_chc_id);
	}

	@Override
	public void updatePlanByplaId(String pla_todo, Long pla_id) {
		// TODO 自动生成的方法存根
		sal_planDao.updatePlanByplaId(pla_todo, pla_id);
	}

	@Override
	public void addPlanById(Date pla_date, String pla_todo,Long pla_chc_id) {
		// TODO 自动生成的方法存根
		sal_planDao.addPlanById(pla_date, pla_todo,pla_chc_id);
	}

}
