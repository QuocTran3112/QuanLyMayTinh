package com.comName.computerWebsite.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comName.computerWebsite.bean.rolebean;
import com.comName.computerWebsite.bean.userbean;
import com.comName.computerWebsite.bo.ghbo;
import com.comName.computerWebsite.dao.quyendao;

/**
 * Servlet implementation class htgioController
 */
@WebServlet("/htgioController")
public class htgioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htgioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
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
    	if (!role.equals("admin")) {
    		request.setAttribute("invalidRole", "Bạn không có quyền xóa");
    	}
    	
		try {
			ghbo gbo = new ghbo();
			// Xử lý yêu cầu khi được gọi qua phương thức GET
			String mm = request.getParameter("mm");
			String tm = request.getParameter("tm");
			String NSX = request.getParameter("NSX");
			String anh = request.getParameter("anh");
			String gia = request.getParameter("gia");
			Long sl = (long) 0;

			if (mm != null && tm != null && NSX != null && anh != null) {
				// them sp
				

				if (request.getSession().getAttribute("gh") == null) {
					request.getSession().setAttribute("gh", gbo);	
				}

				gbo = (ghbo) request.getSession().getAttribute("gh");
				gbo.Themhang(mm, tm, NSX, sl, Long.parseLong(gia), anh);
				request.getSession().setAttribute("gh", gbo);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/client/giohang.jsp");
				request.setAttribute("gh", gbo); 
				rd.forward(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// Xử lý ngoại lệ (exception) tại đây, ví dụ: ghi log hoặc thông báo lỗi
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/client/giohang.jsp");
		ghbo gbo = new ghbo();
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
