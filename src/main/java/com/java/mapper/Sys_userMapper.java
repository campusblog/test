package com.java.mapper;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import com.java.pojo.Sys_role;
import com.java.pojo.Sys_user;

public interface Sys_userMapper {
	/**
	 * 总的人员数据条数
	 * 
	 * @Description TODO
	 * @author 刘凯
	 * @date 2018年5月17日 : 下午7:42:16
	 * @return Long
	 * @throws TODO
	 */
	public Long count();

	/**
	 * 查询所有角色
	 * 
	 * @Description TODO
	 * @author 刘凯
	 * @date 2018年5月17日 : 下午5:11:53
	 * @return List<Sys_role>
	 * @throws TODO
	 */
	public List<Sys_role> selectRolesInfo();

	/**
	 * 查询用户
	 * 
	 * @Description TODO
	 * @author 刘凯
	 * @date 2018年5月15日 : 上午10:49:48
	 * @return int
	 * @throws TODO
	 */
	public int checkUser(@Param("usr_name") String username, @Param("usr_password") String password);

	/**
	 * 查询所有用户
	 * 
	 * @Description TODO
	 * @author 刘凯
	 * @date 2018年5月15日 : 下午3:34:42
	 * @return List<Sys_user>
	 * @throws TODO
	 */
	public List<Sys_user> selectRolesInfo(Map<String, Object> map);

	/**
	 * 添加用户
	 * 
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
	public void deleteUser(@Param("usr_id")Long usr_id);
	/**
	 * 修改用户
	 * @Description TODO 
	 * @author 刘凯
	 * @date 2018年5月18日 : 下午12:06:21
	 * @param id void 
	 * @throws TODO
	 */
	public void updateUser(@Param("usr_role_id") int usr_role_id);
	
	public List<Sys_user> select(Map<String, Object> map) throws Exception;

	public Long getCount(Map<String, Object> map) throws Exception;
}
