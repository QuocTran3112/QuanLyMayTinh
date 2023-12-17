package com.comName.computerWebsite.bo;

import java.util.ArrayList;

import com.comName.computerWebsite.bean.maytinhbean;
import com.comName.computerWebsite.dao.maytinhdao;

public class maytinhbo {
	maytinhdao mtdao = new maytinhdao();
	ArrayList<maytinhbean> ds;
	public ArrayList<maytinhbean> getmay() throws Exception{
		return ds=mtdao.getmay();
	}
	public ArrayList<maytinhbean> getmay1(int index) throws Exception{
		return ds=mtdao.getmay1(index);
	}
	public ArrayList<maytinhbean> TimMa(String maloai,int index) throws Exception {
		return ds = mtdao.getMaloai(maloai, index);
	}
	public int Count() throws Exception{
		return mtdao.Count();
	}
	public int Countml(String maloai) throws Exception{
		return mtdao.Countml(maloai);
	}
	public ArrayList<maytinhbean> timMay(String key) throws Exception{
		ArrayList<maytinhbean> tam = new ArrayList<maytinhbean>();
		for (maytinhbean s : ds) {
			if(s.getMamay().toLowerCase().trim().contains(key.toLowerCase().trim()) || 
			   s.getTenmay().toLowerCase().trim().contains(key.toLowerCase().trim()) || 
			   s.getNSX().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				tam.add(s);
			}
		}
		return tam;
	}
	public Long timsl(String mamay) throws Exception{
		long sl=0;
		for (maytinhbean s : ds) {
			if(s.getMamay().toLowerCase().trim().equals(mamay.toLowerCase().trim())) {
				sl= s.getSoluong();
			}
		}
		return sl;
	}
	public static void main(String[] args) {
		try {
			maytinhbo mtbo =new maytinhbo();
			ArrayList<maytinhbean> ds = mtbo.getmay1(1);
			System.out.println(mtbo.Countml("Dell"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
