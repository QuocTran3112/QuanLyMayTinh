package com.comName.computerWebsite.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.comName.computerWebsite.bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception{
		ArrayList<loaibean> ds= new ArrayList<loaibean>();
		//b1 ket noi vao csdl
		KetNoi kn= new KetNoi();
		kn.KetNoi();
		//b2 tao cau lenh sql
		String sql="select * from loai" ;
		//b3 tao cau lenh
		PreparedStatement cmd=kn.cn.prepareStatement(sql);
		//b4 thuc hien cau lenh
		ResultSet rs= cmd.executeQuery();
		//b5 duyet rs de dua vao mang ds
		while(rs.next()) {
			String maloai=rs.getString("maloai");
			String tenloai=rs.getString("tenloai");
			ds.add(new loaibean(maloai, tenloai));
		}
		rs.close();kn.cn.close();
		return ds;
	}
}
