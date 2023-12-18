<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Đăng nhập</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="resources/img/img_admin/laptopscreen.png" type="image/x-icon">
    <link href="${pageContext.request.contextPath}/resources/css/css_client/dangnhap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="../common/header/header.jsp"></jsp:include>
<div class="center-form">
	<form action="dangnhapController" method="post">
		<div class="form-outline mb-4">
			<h2 class="text-uppercase text-center mb-5" style="color: violet;">Sign in</h2>
             <label class="form-label" for="form3Example3cg" style="color: yellow;">Your Username</label>
             <input type="text" id="form3Example3cg" class="form-control form-control-lg"  name="txtun" />                    
         </div>

         <div class="form-outline mb-4">
              <label class="form-label" for="form3Example4cg" style="color: yellow;">Password</label>
              <input type="password" id="form3Example4cg" class="form-control form-control-lg"  name="txtpass" />                    
         </div>
		 <div class="row mb-4">
    	<div class="col d-flex justify-content-center">
      	<!-- Checkbox -->
      		<div class="form-check">
        		<input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
        		<label class="form-check-label" for="form2Example31" style="color: violet;"> Remember me </label>
      		</div>
    	</div>

    	<div class="col">
      	<!-- Simple link -->
      		<a href="#!" style="color: yellow;">Forgot password?</a>
    	</div>
  		</div>
		<input type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" name="th" value="Log In">
		<!-- Register buttons -->
  		<div class="text-center" style="color: yellow;">
    		<p>Not a member? <a href="dangkyController" style="color: violet;">Register</a></p>   
  		</div>
	</form>
</div>

<div class="center1-form" style="color: red;">
<%
	if(request.getAttribute("kt")!=null){
		out.print("Đăng nhập sai, xem lại tk hoặc mk");
	}

%>
</div>

</body>
</html>