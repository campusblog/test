package com.java.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dao.Sys_userDao;
import com.java.mapper.Sys_userMapper;
import com.java.pojo.Sys_role;
import com.java.pojo.Sys_user;

@Repository
public class Sys_userDaoImpl implements Sys_userDao {
	@Autowired
	private Sys_userMapper sys_UserMapper;

	public Sys_userMapper getSys_UserMapper() {
		return sys_UserMapper;
	}

	public void setSys_UserMapper(Sys_userMapper sys_UserMapper) {
		this.sys_UserMapper = sys_UserMapper;
	}

	@Override
	public int checkUser(String name, String password) {
		// TODO 自动生成的方法存根
		return sys_UserMapper.checkUser(name, password);
	}

	@Override
	public List<Sys_user> selectUsersInfo(Map<String, Object> map) {
		// TODO 自动生成的方法存根
		return sys_UserMapper.selectRolesInfo(map);
	}

	@Override
	public void insertUser(Sys_user sys_user) {
		// TODO 自动生成的方法存根
		sys_UserMapper.insertUser(sys_user);
	}

	@Override
	public List<Sys_role> selectRolesInfo() {
		// TODO 自动生成的方法存根
		return sys_UserMapper.selectRolesInfo();
	}

	@Override
	public List<Sys_user> select(Map<String, Object> map) throws Exception {
		// TODO 自动生成的方法存根
		return sys_UserMapper.select(map);
	}

	@Override
	public Long getCount(Map<String, Object> map) throws Exception {
		// TODO 自动生成的方法存根
		return sys_UserMapper.getCount(map);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO 自动生成的方法存根
		sys_UserMapper.deleteUser(id);
	}

	@Override
	public void updateUser(int id) {
		// TODO 自动生成的方法存根
		sys_UserMapper.updateUser(id);
	}

}
