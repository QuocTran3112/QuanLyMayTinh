<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.comName.computerWebsite.bean.lsmhbean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="resources/img/img_admin/laptopscreen.png" type="image/x-icon">
<title>Lịch sử mua hàng</title>

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
<style type="text/css">

 body {
      background-image: url('resources/img/img_admin/3643882.jpg');
      background-repeat: no-repeat;
      background-attachment: fixed;
      background-size: cover;
    }</style>
   
</head>
<jsp:include page="../common/header/header2.jsp"></jsp:include>	

<body >

	<div id="iddiv" style="margin-left: 250px; width: 1000px">
		<h2>Lịch sử mua hàng</h2>
	<table class="table table-striped table-hover">
	<thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Mã hóa Đơn</th>
      <th scope="col">Ngày mua</th>
      <th scope="col">Mẫu máy</th>
      <th scope="col">Tên máy</th>
      <th scope='col'>Số lượng</th>
    </tr>
  </thead>
			<tbody>
				<% 
			ArrayList<lsmhbean> ds = (ArrayList<lsmhbean>) request.getAttribute("lichsu");
			int n = ds.size();
			for(int i=0;i<n;i++){
				%>
				<tr>
				<%
				lsmhbean l = ds.get(i);
				%>
					<th scope="row"><%=i+1 %></th>
      		<td><%=l.getMaHoaDon() %></td>
      		<td><%=l.getNgayMua() %></td>
      		<td><%=l.getMamay() %></td>
      		<td><%=l.getTenMay()%></td>
      		<td><%=l.getSoluongmua() %></td>
					<%}%>
				</tr>
			</tbody>
		</table>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>