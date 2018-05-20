package com.java.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dao.Sal_chanceDao;
import com.java.mapper.Sal_chanceMapper;
import com.java.pojo.Sal_chance;
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
	public String selectPerson() {
		// TODO 自动生成的方法存根
		return sal_chanceMapper.selectPerson();
	}

}
