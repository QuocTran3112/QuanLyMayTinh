package com.comName.computerWebsite.bean;

public class maytinhbean {
	private String mamay;
	private String tenmay;
	private Long soluong;
	private Long gia;
	private String maloai;
	private String anh;
	private String NSX;
	public maytinhbean() {
		super();
		
	}
	public maytinhbean(String mamay, String tenmay, Long soluong, Long gia,  String maloai, String anh, String NSX ) {
		super();
		this.mamay = mamay;
		this.tenmay = tenmay;
		this.soluong = soluong;
		this.gia = gia;
		this.maloai = maloai;
		this.anh = anh;
		this.NSX = NSX;
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
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	
}
