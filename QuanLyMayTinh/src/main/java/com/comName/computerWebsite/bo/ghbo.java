package com.comName.computerWebsite.bo;

import java.util.ArrayList;

import com.comName.computerWebsite.bean.ghbean;

public class ghbo {
	
	//viết hàm thêm/xóa/tổng tiền vào giỏ:ds
	public ArrayList<ghbean> ds = new ArrayList<ghbean>();
	public void Themhang(String mamay, String tenmay, String NSX, Long soluong, Long gia,
			String anh) throws Exception{
		int n=ds.size();
		if(n!=0) {
			for (int i=0;i<n;i++) {
				if(ds.get(i).getMamay().toLowerCase().trim().equals(mamay.toLowerCase().trim())){
					long sl= ds.get(i).getSoluong()+(long)1;
					ds.get(i).setSoluong(sl);
					long g = ds.get(i).getGia();
					long tt = sl*g;
					ds.get(i).setThanhtien(tt);
					return;
				}
			}
			soluong=(long)1;
			ds.add(new ghbean(mamay, tenmay, NSX, soluong, gia, anh));
		}
		else 
		{
			soluong=(long)1;
			ds.add(new ghbean(mamay, tenmay, NSX, soluong, gia, anh));
		}
	}
	public void Xoahang(String masach) throws Exception{
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMamay().toLowerCase().trim().equals(masach.toLowerCase().trim())) {
				ds.remove(i);
				break;
			}
		}
	}
	public void XoaALL() {
		ds.clear();
	}
	
	public Long Tongtien() throws Exception{
		Long tong=(long) 0;
		for (ghbean gh : ds) {
			tong+= gh.getThanhtien();
		}
		return tong;
	}
	public void Cong(String mamay) throws Exception{
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMamay().toLowerCase().trim().equals(mamay.toLowerCase().trim())) {
				long a = ds.get(i).getSoluong();
				ds.get(i).setSoluong(a+1);
				ds.get(i).setThanhtien(ds.get(i).getSoluong()*ds.get(i).getGia());
				break;
			}
		}
	}
	public void tru(String mamay) throws Exception{
		int n = ds.size();
		for (int i = 0; i < n; i++) {
			if(ds.get(i).getMamay().toLowerCase().trim().equals(mamay.toLowerCase().trim())) {
				long a = ds.get(i).getSoluong();
				if(a>0) {
					ds.get(i).setSoluong(a-1);
					ds.get(i).setThanhtien(ds.get(i).getSoluong()*ds.get(i).getGia());
					break;
				}else { if(a==0){
					Xoahang(mamay);
					}
				}
			}
		}
	}
}