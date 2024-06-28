<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Banca@Dev</title>
<link rel="icon" href="./resources/image/favicon.ico">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginForm.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <div class="main-container">
    	<c:import url="../nav.jsp"></c:import>

	<div class="login-container">
		<div class="login">
			<div class="logo">
				<i class='bx bx-user-circle'></i>
				<p>Login</p>	
			</div>
			<form action="${pageContext.request.contextPath}/login/loginConfirm" method="post">
				<div class="input_box">
					<span>ID</span>
						<div class="icon">
							<i class='bx bxs-user' ></i>
							<input type="text" placeholder="Enter ID" name="user_id" required>
						</div>
				</div>
				<div class="input_box">
					<span>Password</span>
						<div class="icon">
							<i class='bx bxs-lock-alt' ></i>
							<input type="password" placeholder="Enter Password" name="user_pw" required>
						</div>
				</div>
				<div class="forgot_password">
					<a href="#">Forgot Password?</a>
				</div>
				<button type="submit">Login</button>
				<p class="signup">Or Sign Up Using</p>
				<div class="social_icon">
					<a href="#" id="facebook"><i class='bx bxl-facebook' ></i></a>
					<a href="#" id="twitter"><i class='bx bxl-twitter' ></i></a>
					<a href="#" id="google"><i class='bx bxl-google' ></i></a>
					<a href="#" id="github"><i class='bx bxl-github' ></i></a>
				</div>
				<div class="alreadyAccount">
					<p>아직 회원가입을 하지 않았다면? <a href="${pageContext.request.contextPath}/login/joinForm">회원가입</a></p>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>