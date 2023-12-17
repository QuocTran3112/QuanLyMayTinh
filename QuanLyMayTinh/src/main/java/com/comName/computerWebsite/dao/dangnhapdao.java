package com.comName.computerWebsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.comName.computerWebsite.bean.userbean;



public class dangnhapdao {
	public userbean login(String user,String pass)throws Exception{
		String query="select * from [QLMayTinh].[dbo].[user] where username=? and password=?";
		Connection conn = new KetNoi().getConnection();//mo ket noi voi sql
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, pass);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            return new userbean(Integer.parseInt(rs.getString(1)),rs.getString(2), rs.getString(3),rs.getString(4)
            		,rs.getString(5),rs.getString(6),rs.getString(7),Integer.parseInt(rs.getString(8)));
        }
        rs.close();
        ps.close();
        return null;
	}
}
