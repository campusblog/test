package com.java.service.impl;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.common.Sysconst;
import com.java.dao.Sys_userDao;
import com.java.pojo.Sys_role;
import com.java.pojo.Sys_user;
import com.java.service.Sys_userService;
import com.java.util.MD5;
import com.java.util.Page;

@Service
@Transactional
public class Sys_userServiceImpl implements Sys_userService {
	
	@Autowired
	private Sys_userDao sys_userDao;

	public Sys_userDao getSys_userDao() {
		return sys_userDao;
	}

	public void setSys_userDao(Sys_userDao sys_userDao) {
		this.sys_userDao = sys_userDao;
	}

	@Override
	public int checkUser(String usr_name, String usr_password) {
		// TODO 自动生成的方法存根
		String md5Password=MD5.MD5(usr_password);
		return sys_userDao.checkUser(usr_name, md5Password);
	}

	@Override
	public void insertUser(Sys_user sys_user) {
		//将密码加密
		sys_user.setUsr_password(MD5.MD5(sys_user.getUsr_password()));
		sys_userDao.insertUser(sys_user);
	}

	@Override
	public List<Sys_user> selectUsersInfo(Map<String, Object> map) {
		// TODO 自动生成的方法存根
		return sys_userDao.selectUsersInfo(map);
	}

	@Override
	public List<Sys_role> selectRolesInfo() {
		// TODO 自动生成的方法存根
		return sys_userDao.selectRolesInfo();
	}

		
	
	@Override
	public Page<Sys_user> getPage(Map<String, Object> map, Long pageNow, Long pageSize) throws Exception {
		Page<Sys_user> page = new Page<Sys_user>();
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
		Long count = sys_userDao.getCount(map);
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
		List<Sys_user> list = sys_userDao.select(map);
		page.setList(list);
		return page;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO 自动生成的方法存根
		sys_userDao.deleteUser(id);
	}

	@Override
	public void updateUser(int id) {
		// TODO 自动生成的方法存根
		sys_userDao.updateUser(id);
	}

}
