package com.comName.computerWebsite.bean;

public class lsmhbean {
	
	private String MaHoaDon;
	private String NgayMua;
	private String Mamay;
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
	public lsmhbean(String maHoaDon, String ngayMua, String mamay, int soluongmua) {
		super();
		MaHoaDon = maHoaDon;
		NgayMua = ngayMua;
		Mamay = mamay;
		this.soluongmua = soluongmua;
	}

	
}
