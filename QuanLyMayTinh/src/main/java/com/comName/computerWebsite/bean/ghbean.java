package com.comName.computerWebsite.bean;

public class ghbean {
	private String mamay;
	private String tenmay;
	private String NSX;
	private Long soluong;
	private Long gia;
	private Long thanhtien;
	private String anh;
	public ghbean() {
		super();		
	}
	public ghbean(String mamay, String tenmay,String NSX, Long soluong, Long gia, String anh ) {
		super();
		this.mamay = mamay;
		this.tenmay = tenmay;
		this.NSX = NSX;
		this.soluong = soluong;
		this.gia = gia;
		this.thanhtien = soluong*gia;
		this.anh = anh;
	}
	public String getMamay() {
		return mamay;
	}
	public void setMamay(String mamay) {
		this.mamay = mamay;
	}
	public String getTenmay() {
		return tenmay;
	}
	public void setTenmay(String tenmay) {
		this.tenmay = tenmay;
	}
	public String getNSX() {
		return NSX;
	}
	public void setNSX(String nSX) {
		NSX = nSX;
	}
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	@Override
	public String toString() {
		return "ghbean [mamay=" + mamay + ", tenmay=" + tenmay + ", NSX=" + NSX + ", soluong=" + soluong + ", gia="
				+ gia + ", thanhtien=" + thanhtien + ", anh=" + anh + "]";
	}
	
	
}
