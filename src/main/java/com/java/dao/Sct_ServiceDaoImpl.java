package com.java.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.mapper.Sct_ServiceMapper;
import com.java.pojo.Sct_Service;
@Repository
public class Sct_ServiceDaoImpl implements Sct_ServiceDao{
	
	@Autowired
	private Sct_ServiceMapper sct_ServiceMapper;
	@Override
	public Long getCount(Map<String, Object> map) throws Exception {
		// TODO 自动生成的方法存根
		return sct_ServiceMapper.getCount(map);
	}

	@Override
	public List<Sct_Service> select(Map<String, Object> map) throws Exception {
		// TODO 自动生成的方法存根
		return sct_ServiceMapper.select(map);
	}

}
