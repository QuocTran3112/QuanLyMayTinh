package com.comName.computerWebsite.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comName.computerWebsite.bean.userbean;
import com.comName.computerWebsite.dao.dangnhapdao;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//Kiểm tra xem đã đăng nhập trước đấy chưa, nếu rồi thì không cho phép truy cập trang đăng nhập/đăng ký
		userbean firstcheck = (userbean)request.getSession().getAttribute("dn");
		if (firstcheck!=null) {
			response.sendRedirect("maytinhController");
			return;
		}
		
		try {			
			dangnhapdao dndao = new dangnhapdao();
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			userbean dnbean = dndao.login(un, pass);
			if (un != null && pass != null) {
				if (dnbean!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("dn", dnbean);
					response.sendRedirect("maytinhController");
					return;
				} else {
					request.setAttribute("kt", "sai");
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/client/dangnhap.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
