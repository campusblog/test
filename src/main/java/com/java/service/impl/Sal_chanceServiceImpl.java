package com.java.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.common.Sysconst;
import com.java.dao.Sal_chanceDao;
import com.java.mapper.Sal_chanceMapper;
import com.java.pojo.Sal_chance;
import com.java.pojo.Sys_user;
import com.java.service.Sal_chanceService;
import com.java.util.Page;

@Service
@Transactional
public class Sal_chanceServiceImpl implements Sal_chanceService {
	@Autowired
	private Sal_chanceDao sal_chanceDao;

	@Override
	public Page<Sal_chance> getPage(Map<String, Object> map, Long pageNow, Long pageSize) throws Exception {
		Page<Sal_chance> page = new Page<Sal_chance>();
		//1.当前页码
		pageNow = pageNow == null?1:pageNow;
		//防止别有用心的人修改页码
		if(pageNow < 1){
			pageNow = 1L;
		}
		page.setPageNow(pageNow);
		//2.每页显示的信息条数
		pageSize = pageSize == null?Sysconst.PAGE_SIZE:pageSize;
		page.setPageSize(pageSize);
		//3.总的信息条数
		Long count = sal_chanceDao.getCount(map);
		page.setCount(count);
		//4.总的页数
		Long pageCount = count % pageSize == 0?(count / pageSize):(count / pageSize + 1);
		page.setPageCount(pageCount);
		//防止用户在url中乱输入
		if(pageNow > pageCount){
			pageNow = pageCount;
		}
		page.setPageNow(pageNow);
		//5.一页信息(所有的mapper.xml中的分页名字都叫pagesql)
		//5.一页信息(所有的mapper.xml中的分页名字都叫pagesql)
		Long now = (pageNow - 1)*pageSize;
		if( now < 0){
			now = 0L;
		}
		map.put("sqlpage", "limit " + now + "," + pageSize);
		List<Sal_chance> list =sal_chanceDao.select(map);
		page.setList(list);
		return page;
	}

	@Override
	public List<Sal_chance> selectChanceInfo(Map<String, Object> map) throws Exception {
		// TODO 自动生成的方法存根
		return sal_chanceDao.select(map);
	}

	@Override
	public String selectPerson() {
		// TODO 自动生成的方法存根
		return sal_chanceDao.selectPerson();
	}

}
