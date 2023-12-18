package com.comName.computerWebsite.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public Connection KetNoi() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + nameDatabase + "; user=" + useId
				+ "; password=" + passWord+";encrypt=false;trustServerCertificate=true";
		cn = DriverManager.getConnection(url);
		return cn;
	}
	
	public Connection getConnection() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + nameDatabase + "; user=" + useId
				+ "; password=" + passWord +";encrypt=false;trustServerCertificate=true";
		cn = DriverManager.getConnection(url);
		return cn;
	}

	public static Connection cn;
	private final String serverName = "LAPTOP-FH256VT3";
	private final String nameDatabase = "QlMayTinh";
	private final String useId = "quoctran3112";
	private final String passWord = "321103";

}