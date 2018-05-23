package com.java.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dao.Sal_chanceDao;
import com.java.mapper.Sal_chanceMapper;
import com.java.pojo.Sal_chance;
import com.java.pojo.Sys_user;
@Repository
public class Sal_chanceDaoImpl implements Sal_chanceDao {

	@Autowired
	private Sal_chanceMapper sal_chanceMapper;
	
	@Override
	public Long getCount(Map<String, Object> map) throws Exception {
		// TODO 自动生成的方法存根
		return sal_chanceMapper.getCount(map);
	}

	@Override
	public List<Sal_chance> select(Map<String, Object> map) throws Exception {
		// TODO 自动生成的方法存根
		return sal_chanceMapper.select(map);
	}

	@Override
	public List<Sys_user> selectPerson() {
		// TODO 自动生成的方法存根
		return sal_chanceMapper.selectPerson();
	}

	@Override
	public Sal_chance selectCnanceInfo(Long chc_id) {
		// TODO 自动生成的方法存根
		return sal_chanceMapper.selectCnanceInfo(chc_id);
	}

	@Override
	public void updateChance(Long chc_due_id, Date chc_due_date) {
		// TODO 自动生成的方法存根
		sal_chanceMapper.updateChance(chc_due_id, chc_due_date);
	}

}
