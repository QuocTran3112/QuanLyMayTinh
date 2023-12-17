package com.comName.computerWebsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class thanhtoandao {
	
	public void themHDCT(String maChiTiet, String mamay, String soluong, String maHoaDon) throws Exception {
		String query = "insert into ChiTietHoaDon (MaChiTietHD, mamay, soluongmua, MaHoaDon, damua)"
				+ " values(?, ?, ?, (SELECT MaHoaDon from hoadon WHERE MaHoaDon=?), 1);";
		Connection conn = new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, maChiTiet);
		ps.setString(2, mamay);
		ps.setString(3, soluong);
		ps.setString(4, maHoaDon);
		ps.execute();
	}
	
	public void themhoadon(String maHD, String userID, String ngayMua) throws Exception {
		String query = "insert into hoadon values(?, (SELECT userID from [QLMayTinh].[dbo].[user] WHERE userID=?), SYSDATETIME(), 1);";
		Connection conn = new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, maHD);
		ps.setString(2, userID);
		ps.execute();
	}
	
	public int getmaxCTHDID() throws Exception{
		String query = "select MaChiTietHD from ChiTietHoaDon where MaChiTietHD = (select MAX(MaChiTietHD) from ChiTietHoaDon)";
		Connection conn = new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return Integer.parseInt(rs.getString(1));
		}
		return 0;
	}
	
	public int getmaxHDID() throws Exception{
		String query = "select MaHoaDon from hoadon where MaHoaDon = (select MAX(MaHoaDon) from hoadon)";
		Connection conn = new KetNoi().getConnection();
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return Integer.parseInt(rs.getString(1));
		}
		return 0;
	}

}
