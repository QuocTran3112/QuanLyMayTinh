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
import com.comName.computerWebsite.dao.dangkydao;

/**
 * Servlet implementation class dangkyController
 */
@WebServlet("/dangkyController")
public class dangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyController() {
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
			dangkydao dkdao = new dangkydao();
			int userID = dkdao.getuserID();
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			String repass = request.getParameter("txtpass1");
			String realName = request.getParameter("txtrealname");
			String email = request.getParameter("txtemail");
			userbean dnbean = dkdao.checklogin(un);
			if (un != null && pass != null) {
				if(pass.equals(repass)==false){
					request.setAttribute("ktt", "false");
					response.sendRedirect("dangkyController");				
				} else {
				if (dnbean==null) {
					dkdao.sigup(userID+1, un,pass, realName, email, 0);
					HttpSession session = request.getSession();
					session.setAttribute("dn", dnbean);
					response.sendRedirect("dangnhapController");
					return;
				} else {
					request.setAttribute("kt", "false");
				}
			}}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/client/dangky.jsp");
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
