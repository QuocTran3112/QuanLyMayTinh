package com.comName.computerWebsite.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comName.computerWebsite.bean.loaibean;
import com.comName.computerWebsite.bean.maytinhbean;
import com.comName.computerWebsite.bo.loaibo;
import com.comName.computerWebsite.bo.maytinhbo;

@WebServlet("/maytinhController")
public class maytinhController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public maytinhController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			maytinhbo sbo= new maytinhbo();
			loaibo lbo = new loaibo();
			int max=0;
			ArrayList<loaibean> dsloai = lbo.getloai();
			request.setAttribute("dsloai", dsloai);
			//phaan trang
			String indexpage = "";
			String ml1=request.getParameter("ml1");
			String index1=request.getParameter("index1");
			if(index1!=null) {
				indexpage=index1;
			}else {
				indexpage=request.getParameter("index");
			}
			if(indexpage==null) {
				indexpage="1";
			}
			int index = Integer.parseInt(indexpage);
			request.setAttribute("tag", index);
			ArrayList<maytinhbean> ds = sbo.getmay1(index);
			String ml = request.getParameter("ml");
			request.setAttribute("ml", ml);
			
			String key = request.getParameter("txttk");
			if(ml!=null){
				ds=sbo.TimMa(ml,index);
				max=sbo.Countml(ml);
			}else if(key!=null)  {
				ds=sbo.timMay(key);
				max=ds.size();
			}
			if(ml==null && key==null) {
				max = sbo.Count();
			}
			if(ml1!=null&&index1!=null) {
				ds=sbo.TimMa(ml1,index);
				max=sbo.Countml(ml1);
			}
			int maxpage=0;
			if(max%16==0) {
				maxpage=max/16;
			}else {
				maxpage=(max/16)+1;
			}
			request.setAttribute("maxpage", maxpage);
			request.setAttribute("dsmay", ds);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/client/trangchu.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
