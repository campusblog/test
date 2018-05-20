package com.java.pojo;

/**
 * 角色实体类
 * @Description TODO 
 * @author 刘凯
 * @date 2018年5月17日:下午5:04:18
 * @Package com.java.pojo
 * @Project crm
 * @ClassName Sys_role.java
 * @since   JDK1.8
 * @version 1.0
 */
public class Sys_role {

	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public int getRole_flag() {
		return role_flag;
	}
	public void setRole_flag(int role_flag) {
		this.role_flag = role_flag;
	}
	private Long role_id;
	private String role_name;
	private String role_desc;
	private int role_flag;
}
