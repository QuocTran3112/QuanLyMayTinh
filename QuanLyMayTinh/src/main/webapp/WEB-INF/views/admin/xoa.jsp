<%@page import="com.comName.computerWebsite.bo.ghbo"%>
<%@page import="java.awt.RenderingHints"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Xóa</title>
</head>
<body>
<%
String[] gt=request.getParameterValues("c1");
if(gt!=null)
	for(String c: gt)
		out.print("<br>"+c);
String ms2=request.getParameter("but1");
out.print("<hr>"+ms2);
String sl=request.getParameter(ms2);
out.print("Sl: "+sl);
%>
	<%
	ghbo ghbo = (ghbo) session.getAttribute("gh");
	String ms = request.getParameter("ms");
	String ms1 = request.getParameter("ms1");
	String tru = request.getParameter("tru");
	String cong = request.getParameter("cong");
	String[] xoadc = request.getParameterValues("xoadc");
	if (ms != null) {
		ghbo.Xoahang(ms);
	}
	String xoaall = request.getParameter("xoa");
	if (xoaall != null) {
		session.removeAttribute("gh");
	}
	if (tru != null) {
		ghbo.tru(ms1);
	}
	if (cong != null) {
		ghbo.Cong(ms1);
	}
	//xoa da chon
	if(xoadc != null){
		if (ghbo != null) {
            // Xóa các mặt hàng đã chọn
            
		}
	}	
	%>
</body>
</html>