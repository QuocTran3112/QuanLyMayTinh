<%@page import="com.comName.computerWebsite.bean.userbean"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.comName.computerWebsite.bo.ghbo"%>
<%@page import="com.comName.computerWebsite.bean.ghbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Giỏ hàng</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="resources/img/img_admin/basket.png" type="image/x-icon">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />	
  <style>
    body {
    height:100%;
      background-image: url('resources/img/img_admin/backgrounggh.jpg');
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: cover;
    }
  </style>	
</head>
<body>
<jsp:include page="../common/header/header2.jsp"></jsp:include>	
	<%
	String mm = request.getParameter("mm");
	String tm = request.getParameter("tm");
	String NSX = request.getParameter("NSX");
	String anh = request.getParameter("anh");
	String gia = request.getParameter("gia");
	Long sl = (long) 0;
	if (mm != null && tm != null && NSX != null && anh != null) {
		ghbo ghbo = new ghbo();
		if (session.getAttribute("gh") == null) {
			session.setAttribute("gh", ghbo);
		}
		ghbo = (ghbo) session.getAttribute("gh");
		ghbo.Themhang(mm, tm, NSX, sl, Long.parseLong(gia), anh);
		session.setAttribute("gh", ghbo);
	}
	if (session.getAttribute("gh") != null) {
		ghbo ghbo = (ghbo) session.getAttribute("gh");
		int n = ghbo.ds.size();
	%>
	<section class="title-cart border-bottom border-danger border-3">
		<div class="container">
			<div class="row pt-3">
				<div class="col-12 a-left  mb-4 fs-4">
					<h3>GIỎ HÀNG</h3>
				</div>
			</div>
	</section>
	<section class="product-cart border-bottom border-danger border-3">
		<div class="container">
			<div class="row mb-5">
				<form class="col-md-12" action ="thanhtoanController" method="post">
					<div class="site-blocks-table">
						<table class="table">
							<thead>
								<tr>
									<th scope="col col-md-2 ">Sản phẩm</th>
									<th scope="col col-md-2 ">Tên </th>
									<th scope="col col-md-2">Đơn giá</th>
									<th scope="col col-md-2">Số lượng</th>
									<th scope="col col-md-2">Thành tiền</th>
									<th scope="col col-md-2">Checkbox</th>
									<th scope="col col-md-2">Xóa</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (int i = 0; i < n; i++) {
									ghbean g = ghbo.ds.get(i);
								%>
								<tr>
									<td class="row">
										<div class="col-md-6">
											<img src="resources/img/img_products/<%=g.getAnh()%>" alt="CAP"
												style="width: 100px;">
										</div>
									</td>
									<td><div class="col-md-6 mt-5 text-start"><%=g.getTenmay()%></div></td>
									<td><div class="mt-5"><%=g.getGia()%>vnđ
										</div></td>
									<td>
										<!--<div class="mt-5"g.getSoluong()g() %></div>  -->
												<p style="justify-content: center;display: flex"><%=g.getSoluong()%></p>
									</td>
									<td><div class="mt-5"><%=g.getThanhtien()%>vnđ</div></td>
									<td><input type="checkbox" name="deleteSelected" value="<%=g.getMamay()%>"></td>
									<td><div class="mt-5">
											<a href="xoaController?mm=<%=g.getMamay()%>"> <i class="fa-solid fa-trash text-success"></i></a>
										</div></td>
								</tr>
								<%}%>							
						</table>
						<div align='right' style="font-size: 18px">
					<strong>Tổng tiền:<%=ghbo.Tongtien()%>vnđ
					</strong>
				</div>
						<div style="justify-content: center; display: flex;">
						<input type="submit" value="Xác nhận mua" class="btn-btn warning"></div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<%
	} else {
	%>
	<div align="center">Không có sản phẩm nào!</div>
	<div align="center">
		<a href="maytinhController"><button type="button"
				class="btn btn-success w-100" name="Mua thêm">Mua thêm</button></a>
	</div>
	<%}%>

</body>
</html>
