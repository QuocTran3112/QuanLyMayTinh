package com.comName.computerWebsite.bo;

import java.util.ArrayList;

import com.comName.computerWebsite.bean.loaibean;
import com.comName.computerWebsite.dao.loaidao;

public class loaibo {
	loaidao ldao= new loaidao();
	public ArrayList<loaibean> getloai() throws Exception{
		return ldao.getloai();
	} 
}
