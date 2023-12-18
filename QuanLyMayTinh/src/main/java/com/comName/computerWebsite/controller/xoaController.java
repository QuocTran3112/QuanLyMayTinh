package com.comName.computerWebsite.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comName.computerWebsite.bean.rolebean;
import com.comName.computerWebsite.bean.userbean;
import com.comName.computerWebsite.bo.ghbo;
import com.comName.computerWebsite.dao.quyendao;

/**
 * Servlet implementation class xoaController
 */
@WebServlet("/xoaController")
public class xoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	userbean user = (userbean)request.getSession().getAttribute("dn");
    	quyendao qd = new quyendao();
    	ArrayList<rolebean> roles = new ArrayList<rolebean>();
    	try {
			roles = qd.getRoles();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String role = "";
    	if (user!=null ) {
    		for (int i =0; i<roles.size();i++) {
        		if (roles.get(i).getRoleID()==user.getRoleID()) {
        			role = roles.get(i) .getRoleName();
        		}
        	}
    	}
    	
		if (role.equals("admin")) {
			HttpSession session = request.getSession();
			ghbo ghbo = (ghbo) session.getAttribute("gh");
			String mm = request.getParameter("mm");
			String mm1 = request.getParameter("mm1");
			String tru = request.getParameter("tru");
			String cong = request.getParameter("cong");
			String[] xoadc = request.getParameterValues("xoadc");
			try {
				if (mm != null) {
					ghbo.Xoahang(mm);
				}
				String xoaall = request.getParameter("xoa");
				if (xoaall != null) {
					session.removeAttribute("gh");
				}
				if (tru != null) {
					ghbo.tru(mm1);
				}
				if (cong != null) {
					ghbo.Cong(mm1);
				}
				//xoa da chon
				String[] a = request.getParameterValues("deleteSelected");
				if(a != null){
					for (String deleteSelected : a) {
						ghbo.Xoahang(deleteSelected);
					}
				}
				RequestDispatcher rd = request.getRequestDispatcher("htgioController");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			request.setAttribute("invalid", "Bạn không có quyền xóa");
			request.setAttribute("invalidRole", "Bạn không có quyền xóa");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/client/giohang.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
