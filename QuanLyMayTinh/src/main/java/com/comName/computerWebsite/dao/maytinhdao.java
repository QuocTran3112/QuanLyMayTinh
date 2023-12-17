package com.comName.computerWebsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.comName.computerWebsite.bean.maytinhbean;

public class maytinhdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public ArrayList<maytinhbean> getmay() throws Exception {
		ArrayList<maytinhbean> ds = new ArrayList<maytinhbean>();
		String query = "select * from maytinh";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				String mamay = rs.getString("mamay");
				String tenmay = rs.getString("tenmay");
				String NSX = rs.getString("NSX");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new maytinhbean(mamay, tenmay, soluong, gia, maloai, anh, NSX));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return ds;
	}
	
	public ArrayList<maytinhbean> getmay1(int index) throws Exception {
		ArrayList<maytinhbean> ds = new ArrayList<maytinhbean>();
		String query = "select * from maytinh order by mamay offset ? rows fetch next 15 rows only";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*15);
			rs = ps.executeQuery();
			while (rs.next()) {
				String mamay = rs.getString("mamay");
				String tenmay = rs.getString("tenmay");
				String NSX = rs.getString("NSX");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new maytinhbean(mamay, tenmay, soluong, gia, maloai, anh, NSX));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return ds;
	}
	public ArrayList<maytinhbean> getMaloai(String maloai1,int index) throws Exception {
		ArrayList<maytinhbean> ds = new ArrayList<maytinhbean>();
		String query = "select * from maytinh where maloai=? order by mamay offset ? rows fetch next 15 rows only ";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, maloai1);
			ps.setInt(2, (index-1)*15);
			rs = ps.executeQuery();
			while (rs.next()) {
				String mamay = rs.getString("mamay");
				String tenmay = rs.getString("tenmay");
				String NSX = rs.getString("NSX");
				Long soluong = rs.getLong("soluong");
				Long gia = rs.getLong("gia");
				String anh = rs.getString("anh");
				String maloai = rs.getString("maloai");
				ds.add(new maytinhbean(mamay, tenmay, soluong, gia, maloai, anh, NSX));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return ds;
	}
	public int Count() throws Exception{
		String query = "select count(*) from maytinh";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return 0;
	}
	public int Countml(String maloai) throws Exception{
		String query = "  select count(*) from maytinh where maloai=?";
		try {
			conn = new KetNoi().getConnection();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, maloai);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs.close();
		conn.close();
		return 0;
	}
	public static void main(String[] args) {
		try {
			maytinhdao mtdao = new maytinhdao();
			ArrayList<maytinhbean> ds = mtdao.getmay1(1);
			System.out.println(mtdao.Countml("Dell"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
