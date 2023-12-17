<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.comName.computerWebsite.bo.ghbo"%>
<%@page import="com.comName.computerWebsite.bean.ghbean"%>
<%@page import="com.comName.computerWebsite.bean.userbean"%>
    <%
long slm=0;
if(session.getAttribute("gh")!= null){
	ghbo ghb = new ghbo();
	ghb = (ghbo)session.getAttribute("gh");
	slm = ghb.ds.size();
}
%>
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="maytinhController"><img src="resources/img/img_admin/logo.png" alt="Logo" style="max-height: 60px;"></a></li>
				<li><a href="htgioController">Giỏ hàng(<%=slm%>)</a></li>
				<li><a href="thanhtoanController">Thanh toán</a></li>
				<li><a href="lichsumuahang">Lịch sử mua hàng</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%
				if (session.getAttribute("dn") != null) {
					userbean us = (userbean)session.getAttribute("dn");
				%>
				<li><a href="#"><span class="glyphicon glyphicon-user">Hi!<%=us.getHoten()%></span>
				</a></li>
				<li><a href="dangxuatController"><span
						class="glyphicon glyphicon-log-out"></span>Đăng xuất</a></li>
				<%
				} else {
				%>
				<li><a href="dangnhapController"><span
						class="glyphicon glyphicon-log-out"></span>Đăng nhập</a></li>
				<li><a href="dangkyController"><span
						class="glyphicon glyphicon-log-in"></span>Đăng kí</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</nav>