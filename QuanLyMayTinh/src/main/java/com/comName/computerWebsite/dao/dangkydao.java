package com.comName.computerWebsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.comName.computerWebsite.bean.userbean;

public class dangkydao {
	public userbean checklogin(String user)throws Exception{
		String query="select * from [QLMayTinh].[dbo].[user] where username=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return new userbean(Integer.parseInt(rs.getString(1)),rs.getString(2), rs.getString(3),rs.getString(4)
            		,rs.getString(5),rs.getString(6),rs.getString(7),Integer.parseInt(rs.getString(8)));
        }
        rs.close();
        ps.close();
        return null;
	}
	public void sigup(int userID,String user,String pass, String realName, String email, int roleID) throws Exception{
		String query="insert into [QLMayTinh].[dbo].[user] values(?,?,?,?,?,?,?,?)";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, String.valueOf(userID));
        ps.setString(2, realName);
        ps.setString(3, null);
        ps.setString(4, null);
        ps.setString(5, email);
        ps.setString(6, user);
        ps.setString(7, pass);
        ps.setString(8, String.valueOf(roleID));
        ps.executeUpdate();
        ps.close();
	}
	public int getuserID() throws Exception{
		String query = "select userID from [QLMayTinh].[dbo].[user] where userID = (select MAX(userID) from [QLMayTinh].[dbo].[user])";
		Connection conn = new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return Integer.parseInt(rs.getString(1));
		}
		return 0;
	}
	public static void main(String[] args) {
		dangkydao dkdao = new dangkydao();
		try {
			userbean dnbean = dkdao.checklogin("abcdf");
			if(dnbean==null) {
				System.out.println("Ko có");
			}else {
				System.out.println("Có");
			}
			/* dkdao.sigup("a1","123"); */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
