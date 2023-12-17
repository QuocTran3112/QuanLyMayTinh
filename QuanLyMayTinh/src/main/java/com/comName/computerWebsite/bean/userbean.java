package com.comName.computerWebsite.bean;

import com.comName.computerWebsite.bo.ghbo;

public class userbean {
	
	private int userID;
	private String hoten;
	private String diachi;
	private String sdt;
	private String email;
	private String username;
	private String password;
	private int roleID;
	private ghbo GHB;
	
	/**
	 * @param userID
	 * @param hoten
	 * @param diachi
	 * @param sdt
	 * @param email
	 * @param username
	 * @param password
	 * @param roleID
	 * @param gHB
	 */
	public userbean(int userID, String hoten, String diachi, String sdt, String email, String username, String password, int roleID) {
		super();
		this.userID = userID;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.username = username;
		this.roleID = roleID;
		this.password = password;
		GHB = new ghbo();
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ghbo getGHB() {
		return GHB;
	}
	public void setGHB(ghbo gHB) {
		GHB = gHB;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
}
