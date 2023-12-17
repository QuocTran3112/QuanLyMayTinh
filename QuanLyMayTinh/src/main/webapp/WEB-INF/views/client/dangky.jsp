<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Đăng Ký Tài Khoản</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="writtenpaper.png" type="image/x-icon">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
        html, body {
        	height:100%;
            margin: 0;
            font-family: Arial, sans-serif;
            background-image: url('resources/img/img_admin/bglogin.gif');
            background-size: cover;
        }

.center-form {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 60%;
}
</style>    
</head>
<body>
<jsp:include page="../common/header/header.jsp"></jsp:include>
<div class="center-form">
<form action="dangkyController" method="post">
<div class="form-outline mb-4">
<h2 class="text-uppercase text-center mb-5" style="color: violet;">Create an account</h2>
         <label class="form-label" for="form3Example3cg" style="color: yellow;">Your Username</label>
         <input type="text" id="form3Example3cg" class="form-control form-control-lg"  name="txtun" required="required"/>                    
     </div>
     <div class="form-outline mb-4">
          <label class="form-label" for="form3Example2cg" style="color: yellow;">Real Name</label>
          <input type="text" id="form3Example2cg" class="form-control form-control-lg"  name="txtrealname" required="required"/>                    
     </div>
     <div class="form-outline mb-4">
          <label class="form-label" for="form3Example2cg" style="color: yellow;">Real Name</label>
          <input type="email" id="form3Example2cg" class="form-control form-control-lg"  name="txtemail" required="required"/>                    
     </div>
     <div class="form-outline mb-4">
          <label class="form-label" for="form3Example4cg" style="color: yellow;">Password</label>
          <input type="password" id="form3Example4cg" class="form-control form-control-lg"  name="txtpass" required="required"/>                    
     </div>
     <div class="form-outline mb-4">
          <label class="form-label" for="form3Example4cg" style="color: yellow;">Repeat Password</label>
          <input type="password" id="form3Example4cg" class="form-control form-control-lg" name="txtpass1"/>      
          <%if(request.getAttribute("kt")!=null){ %>
			<p class="text-danger">Wrong!User name already exist!</p>
	 	  <%}%>
          <%if(request.getAttribute("ktt")!=null){ %>
			<p class="text-danger">Repeated password does not match!</p>
	 	  <%}%>              
     </div>
 <div class="row mb-4">
  <div class="col d-flex justify-content-center">
    <!-- Checkbox -->
      <div class="form-check">
        <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
        <label class="form-check-label" for="form2Example31"style="color: green;"> I agree all statements in </label> <a href="#!" style="color: violet;" 	>Terms of service</a>
      </div>
  </div>

  </div>
<input type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body" name="th" value="Register">
<!-- Register buttons -->
  <div class="text-center" style="color: yellow;">
    <p>Have already an account? <a href="dangnhapController" style="color: violet;">Log in here</a></p>   
  </div>
</form>
</div>

</body>
</html>
