<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/resources/css/css_client/header1.css" rel="stylesheet" type="text/css">
<nav class="navbar navbar-light">
    <div class="container-fluid">
        <div class="navbar-header">
	<a href="maytinhController"><img id="idLogo" src="resources/img/img_admin/logo.png" alt="Logo" style="max-width: 67px"></a>	
        </div>
        <ul class="nav navbar-nav">
            <li><a href="htgioController">Giỏ hàng</a></li>
            <li><a href="thanhtoan.jsp">Thanh toán</a></li>
            <li><a href="lichsumuahang">Lịch sử mua hàng</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            	<%if(session.getAttribute("dn")!=null){%>
				<li><a href="#"><span class="glyphicon glyphicon-user">Hi!<%=session.getAttribute("dn") %></span> </a></li>
				<li><a href="dangxuat.jsp"><span class="glyphicon glyphicon-log-out"></span>Đăng xuất</a></li>
					
				<%}else{ %>
				<li><a href="dangnhapController"><span class="glyphicon glyphicon-log-out" style="align-items: center;margin-right: 4px;"></span>Đăng nhập</a></li>
				<li><a href="dangkyController"><span class="glyphicon glyphicon-log-in" style="align-items: center; margin-right: 4px;"></span>Đăng kí</a></li>
				<%} %>
        </ul>
    </div>
</nav>