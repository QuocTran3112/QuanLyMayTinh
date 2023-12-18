package com.comName.computerWebsite.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comName.computerWebsite.bean.lsmhbean;
import com.comName.computerWebsite.bean.userbean;
import com.comName.computerWebsite.dao.lichsumuahangdao;

@WebServlet("/lichsumuahang")
public class lichsumuahangController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		userbean firstcheck = (userbean)req.getSession().getAttribute("dn");
		if (firstcheck==null) {
			resp.sendRedirect("dangnhapController");
			return;
		}
		
		lichsumuahangdao lsmh = new lichsumuahangdao();
		userbean user = (userbean)req.getSession().getAttribute("dn");
		ArrayList<lsmhbean> ls = new ArrayList<lsmhbean>();
		try {
			ls = lsmh.getlsmh(String.valueOf(user.getUserID()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("lichsu", ls);
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/client/lichsumuahang.jsp");
		rd.forward(req, resp);
	}

}
