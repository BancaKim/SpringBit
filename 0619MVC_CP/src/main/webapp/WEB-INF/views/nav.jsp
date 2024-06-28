<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index2.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
</head>
<body>
<!--     <div class="main-container"> -->
        <nav>
            <img src="${pageContext.request.contextPath}/resources/image/logo.png" class="logo">
            <ul>
                <li><a href="${pageContext.request.contextPath}/home">홈</a></li>
                <li><a href="${pageContext.request.contextPath}/board/list">게시판</a></li>
                <li><a href="${pageContext.request.contextPath}/basket/setProduct">장바구니</a></li> 
	<c:if test="${user_id !=null && user_id.equals('admin')}">
                <li><a href="${pageContext.request.contextPath}/login/memberList">운영자화면</a></li>  
	</c:if>
            </ul>
            
    <c:choose>
	    <c:when test="${user_id != null}">
     	   <div>
           	<span>${user_id}님 환영합니다!</span>
            <a href="${pageContext.request.contextPath}/login/logout" class="btn">로그아웃</a>                
           </div>
	    </c:when>
	    <c:otherwise>
	        <div>
           		 <a href="${pageContext.request.contextPath}/login/loginForm" class="btn">로그인</a>            
            </div>
	    </c:otherwise>
    </c:choose>        
        </nav>
</body>
</html>