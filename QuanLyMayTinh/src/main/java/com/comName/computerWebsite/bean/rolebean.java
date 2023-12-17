package com.comName.computerWebsite.bean;

public class rolebean {
	
	private int roleID;
	private String roleName;
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public rolebean(int roleID, String roleName) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
	}
	

}
