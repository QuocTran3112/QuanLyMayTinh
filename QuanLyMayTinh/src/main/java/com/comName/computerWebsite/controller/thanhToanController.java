package com.comName.computerWebsite.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comName.computerWebsite.bean.ghbean;
import com.comName.computerWebsite.bean.userbean;
import com.comName.computerWebsite.bo.ghbo;
import com.comName.computerWebsite.dao.thanhtoandao;

@WebServlet("/thanhtoanController")
public class thanhToanController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		userbean firstcheck = (userbean)req.getSession().getAttribute("dn");
		if (firstcheck==null) {
			resp.sendRedirect("dangnhapController");
			return;
		}
		
		ghbo gbo = (ghbo) req.getSession().getAttribute("gh");
		req.getSession().setAttribute("gh", gbo);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/client/thanhtoan.jsp");
		req.setAttribute("gh", gbo); 
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		thanhtoandao ttdao = new thanhtoandao();
		userbean user = (userbean)req.getSession().getAttribute("dn");
		
		int maHD=0;
		try {
			maHD = ttdao.getmaxHDID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int hd = maHD+1;
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD'T'HH:mm:ss");
		df.format(date);
		
		try {
			ttdao.themhoadon(String.valueOf(hd), String.valueOf(user.getUserID()), df.format(date));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ghbo ghbo = (ghbo) req.getSession().getAttribute("gh");
		ArrayList<ghbean> ds = ghbo.ds;
		for (int i=0; i<ds.size();i++) {
			try {
				int maCTHD=0;
				try {
					maCTHD = ttdao.getmaxCTHDID();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int cthd = maCTHD+1;
				ttdao.themHDCT(String.valueOf(cthd), ds.get(i).getMamay(), String.valueOf(ds.get(i).getSoluong()), String.valueOf(hd));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		req.getSession().setAttribute("gh", null);
		resp.sendRedirect("maytinhController");
	}

}
