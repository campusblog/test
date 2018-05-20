package com.java.dao;

import java.util.List;
import java.util.Map;

import com.java.pojo.Sys_role;
import com.java.pojo.Sys_user;

public interface Sys_userDao {
	/**
	 * 查询所有角色
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月17日 : 下午5:11:53
	 * @return List<Sys_role> 
	 * @throws TODO
	 */
	public List<Sys_role> selectRolesInfo();
	
	/**
	 * 查询用户
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月15日 : 上午10:49:48
	 * @return int 
	 * @throws TODO
	 */
	public int checkUser(String usr_name,String usr_password);
	/**
	 * 查询所有用户
	 * @Description TODO
	 * @author 刘凯
	 * @date 2018年5月15日 : 下午3:34:42
	 * @return List<Sys_user>
	 * @throws TODO
	 */
	public List<Sys_user> selectUsersInfo(Map<String, Object> map);
	/**
	 * 添加用户
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月17日 : 上午9:52:51 void 
	 * @throws TODO
	 */
	public void insertUser(Sys_user sys_user);
	/**
	 * 删除用户
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午12:04:49
	 * @param id void 
	 * @throws TODO
	 */
	public void deleteUser(Long id);
	/**
	 * 修改用户
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午12:06:21
	 * @param id void 
	 * @throws TODO
	 */
	public void updateUser(int id);

	public List<Sys_user> select(Map<String, Object> map) throws Exception;

	public Long getCount(Map<String, Object> map) throws Exception;
	
}
