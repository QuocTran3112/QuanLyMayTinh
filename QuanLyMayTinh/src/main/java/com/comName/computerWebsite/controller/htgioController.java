package com.comName.computerWebsite.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comName.computerWebsite.bo.ghbo;

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
