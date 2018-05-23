package com.java.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dao.Cst_customerDao;
import com.java.mapper.Cst_customerMapper;
import com.java.pojo.Cst_customer;
@Repository
public class Cst_customerDaoImpl implements Cst_customerDao{

	@Autowired
	private Cst_customerMapper cst_customerMapper;
	@Override
	public Long getCount(Map<String, Object> map) throws Exception {
		// TODO 自动生成的方法存根
		return cst_customerMapper.getCount(map);
	}

	@Override
	public List<Cst_customer> select(Map<String, Object> map) throws Exception {
		// TODO 自动生成的方法存根
		return cst_customerMapper.selectAllCustomer(map);
	}

	@Override
	public Cst_customer selectCustomerById(Long cust_no) {
		// TODO 自动生成的方法存根
		return cst_customerMapper.selectCustomerById(cust_no);
	}

	@Override
	public void deleteCustomerById(Long cust_no) {
		// TODO 自动生成的方法存根
		cst_customerMapper.deleteCustomerById(cust_no);
	}

}
