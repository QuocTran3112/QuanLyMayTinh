<%@page import="com.comName.computerWebsite.dao.maytinhdao"%>
<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
<%@page import="com.comName.computerWebsite.bo.ghbo"%>
<%@page import="com.comName.computerWebsite.bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.comName.computerWebsite.bean.maytinhbean"%>
<%@page import="com.comName.computerWebsite.bean.userbean"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.comName.computerWebsite.bo.maytinhbo"%>
<%@page import="com.comName.computerWebsite.bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thế Giới LapTop</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="resources/img/img_admin/laptopscreen.png" type="image/x-icon">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style type="text/css">
.pagination-container {
    text-align: center;
}

.pagination {
    display: inline-block;
}
    
    </style>
</head>


<body>
<jsp:include page="../common/header/header2.jsp"></jsp:include>	
	<%
		maytinhbo mtbo= new maytinhbo();

	%>
	<table class="table">
		<tr>
			<td width="200" valign="top">
				<table class="table table-hover">
					<h3 class="category-box">Danh Mục</h3>
					<%
					ArrayList<loaibean> dsloai= (ArrayList<loaibean>)request.getAttribute("dsloai");
					for(loaibean l : dsloai) { %>
						<tr>
							<td>
								<a href="maytinhController?ml=<%=l.getMaloai() %>"><%=l.getTenloai() %></a>
							</td>
						</tr>
					<%}%>
				</table>
			</td>
			<td width="600" valign="top">
		<table class="table">
			<% 
			ArrayList<maytinhbean> ds = (ArrayList<maytinhbean>) request.getAttribute("dsmay");
			int n = ds.size();
			for(int i=0;i<n;i+=3){
				%>
				<tr>
				<%
				for(int j = 0; j < 3 && (i + j) < n; j++) {
					maytinhbean mtb = ds.get(i + j);
				%>
					<td>
						<a href="thongtinsp.jsp?mm=<%=mtb.getMamay()%>&tm=<%=mtb.getTenmay()%>&gia=<%=mtb.getGia()%>&NSX=<%=mtb.getNSX()%>&anh=<%=mtb.getAnh()%>&sl=<%=mtb.getSoluong()%>" class="text-decoration-none">
						<img alt="maytinh" src="resources/img/img_products/<%=mtb.getAnh()%>" width="270px" height="230px"> <br>
						<strong><%=mtb.getTenmay() %></strong> <br></a>
						<strong><%=mtb.getNSX() %></strong> <br>
						<strong><%=mtb.getGia() %>vnd</strong> <br>
						<a href="htgioController?mm=<%=mtb.getMamay()%>&tm=<%=mtb.getTenmay()%>&gia=<%=mtb.getGia()%>&NSX=<%=mtb.getNSX()%>&anh=<%=mtb.getAnh()%>">
							<button type="button" class="btn-danger">Đặt hàng</button> 	
						</a>
					</td>
					<%}%>
				</tr>
				<%}%>
		</table>

		<!-- Phần hiển thị nút phân trang -->
<nav aria-label="Pagination Navigation" class="pagination-container">
    <ul class="pagination">
        <% 
        int maxpage = (Integer) request.getAttribute("maxpage"); 
        int currentPage = (Integer) request.getAttribute("tag"); 
        String ml = request.getParameter("ml");
        String key = request.getParameter("txttk");

        String prevLink = "maytinhController?index=" + (currentPage - 1);
        if(ml != null) prevLink += "&ml=" + ml;
        if(key != null) prevLink += "&txttk=" + key;

        String nextLink = "maytinhController?index=" + (currentPage + 1);
        if(ml != null) nextLink += "&ml=" + ml;
        if(key != null) nextLink += "&txttk=" + key;
        %>

        <!-- Previous button -->
        <li class="page-item <% if(currentPage == 1) { %>disabled<% } %>">
            <a class="page-link" href="<% if(currentPage > 1) { %><%= prevLink %><% } else { %>#<% } %>" tabindex="-1">Previous</a>
        </li>

        <!-- Page numbers -->
        <% for(int i = 1; i <= maxpage; i++) { 
            String link = "maytinhController?index=" + i;
            if(ml != null) link += "&ml=" + ml;
            if(key != null) link += "&txttk=" + key;
        %>
            <% if(currentPage == i) { %>
                <li class="page-item active">
                    <a class="page-link" href="#"><%= i %><span class="sr-only">(current)</span></a>
                </li>
            <% } else { %>
                <li class="page-item">
                    <a class="page-link" href="<%= link %>"><%= i %></a>
                </li>
            <% }
        } %>

        <!-- Next button -->
        <li class="page-item <% if(currentPage == maxpage) { %>disabled<% } %>">
            <a class="page-link" href="<% if(currentPage < maxpage) { %><%= nextLink %><% } else { %>#<% } %>">Next</a>
        </li>
    </ul>
</nav>
			
	</td>

		</tr>
	</table>

</body>
</html>