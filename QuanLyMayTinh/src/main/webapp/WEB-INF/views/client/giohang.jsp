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
				<form class="col-md-12" method="post" action ="xoaController">
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
										<form action="xoaController?ms=" <%=g.getMamay()%> method="post">
											<a href="xoaController?tru=t&mm1=<%=g.getMamay()%>"><button
													type="button" class="btn warning" name="tru">-</button></a> <input
												type="text" name="txtsl" style="width: 40px;" id=""
												value="<%=g.getSoluong()%>"> <a
												href="xoaController?cong=c&mm1=<%=g.getMamay()%>"><button
													type="button" class="btn warning" name="cong">+</button></a>
										</form>
									</td>
									<td><div class="mt-5"><%=g.getThanhtien()%>vnđ</div></td>
									<td><input type="checkbox" name="deleteSelected" value="<%=g.getMamay()%>"></td>
									<td><div class="mt-5">
											<a href="xoaController?mm=<%=g.getMamay()%>"> <i class="fa-solid fa-trash text-success"></i></a>
										</div> <% if (request.getAttribute("invalidRole")!=null) {
											out.print(request.getAttribute("invalidRole")); }%>
										</td>
								</tr>
								<%}%>							
						</table>
						<input type="submit" name="xoadc" value="Xóa đã chọn" class="btn-btn warning">
					</div>
				</form>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-8 right">
				<div align='left' style="font-size: 18px">
					<strong>Tổng tiền:<%=ghbo.Tongtien()%>vnđ
					</strong>
				</div>
				<a href="thanhtoanController"><button type="button" class="btn-btn light">Thanh toán</button></a> 
				<a href="maytinhController"><button type="button" class="btn-btn light" name="Mua thêm">Mua thêm</button></a> 
				<a href="xoaController?xoa=x"><button type="button" class="btn-btn light" name="xoaAll">Xóa hết</button></a> 						
			</div>
		</div>
	</div>
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
