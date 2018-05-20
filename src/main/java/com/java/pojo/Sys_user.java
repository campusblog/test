package com.java.pojo;

/**
 * 系统用户类
 * @Description TODO 
 * @author 刘凯
 * @date 2018年5月15日:上午9:54:57
 * @Package com.java.pojo
 * @Project crm
 * @ClassName Sys_user.java
 * @since   JDK1.8
 * @version 1.0
 */
public class Sys_user {

	private Long usr_id;//用户id
	private String usr_name;//用户登录名
	private String usr_password;//密码
	public Long getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(Long usr_id) {
		this.usr_id = usr_id;
	}
	public String getUsr_name() {
		return usr_name;
	}
	public void setUsr_name(String usr_name) {
		this.usr_name = usr_name;
	}
	public String getUsr_password() {
		return usr_password;
	}
	public void setUsr_password(String usr_password) {
		this.usr_password = usr_password;
	}
	public Long getUsr_role_id() {
		return usr_role_id;
	}
	public void setUsr_role_id(Long usr_role_id) {
		this.usr_role_id = usr_role_id;
	}
	public Integer getUsr_flag() {
		return usr_flag;
	}
	public void setUsr_flag(Integer usr_flag) {
		this.usr_flag = usr_flag;
	}
	private Long usr_role_id;//用户角色编号
	private Integer usr_flag;//用户标识
}
