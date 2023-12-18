package com.comName.computerWebsite.bean;

public class lsmhbean {
	
	private String MaHoaDon;
	private String NgayMua;
	private String Mamay;
	private String tenMay;
	public lsmhbean(String maHoaDon, String ngayMua, String mamay, String tenMay, int soluongmua) {
		super();
		MaHoaDon = maHoaDon;
		NgayMua = ngayMua;
		Mamay = mamay;
		this.tenMay = tenMay;
		this.soluongmua = soluongmua;
	}
	public String getTenMay() {
		return tenMay;
	}
	public void setTenMay(String tenMay) {
		this.tenMay = tenMay;
	}
	private int soluongmua;
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public String getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(String ngayMua) {
		NgayMua = ngayMua;
	}
	public String getMamay() {
		return Mamay;
	}
	public void setMamay(String mamay) {
		Mamay = mamay;
	}
	public int getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(int soluongmua) {
		this.soluongmua = soluongmua;
	}
	
}
