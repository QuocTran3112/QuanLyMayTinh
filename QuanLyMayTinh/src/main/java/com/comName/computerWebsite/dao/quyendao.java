package com.comName.computerWebsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.comName.computerWebsite.bean.rolebean;

public class quyendao {

	public ArrayList<rolebean> getRoles() throws Exception {
		String query = "select * from [QLMayTinh].[dbo].[role]";
		Connection conn = new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<rolebean> roles = new ArrayList<rolebean>();
		while (rs.next()) {
			roles.add(new rolebean(Integer.parseInt(rs.getString(1)), rs.getString(2)));
		}
		return roles;
	}
	
}
