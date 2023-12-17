package com.comName.computerWebsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.comName.computerWebsite.bean.lsmhbean;

public class lichsumuahangdao {
	
	public ArrayList<lsmhbean> getlsmh(String userID) throws Exception {
		String query = "select hoadon.MaHoaDon, hoadon.NgayMua, ChiTietHoaDon.mamay, ChiTietHoaDon.soluongmua from hoadon " 
				+"inner join [QLMayTinh].[dbo].[user] on [QLMayTinh].[dbo].[user].userID =? " 
				+"inner join ChiTietHoaDon on hoadon.MaHoaDon = ChiTietHoaDon.MaHoaDon";
		Connection conn = new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, userID);
		ResultSet rs = ps.executeQuery();
		ArrayList<lsmhbean> ls = new ArrayList<lsmhbean>();
		while (rs.next()) {
			lsmhbean l = new lsmhbean(rs.getString(1), rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)));
			ls.add(l);
		}
		return ls;
	}

}
