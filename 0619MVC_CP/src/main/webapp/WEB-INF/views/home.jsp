<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
</head>
<body>
    <div class="main-container">
    	<c:import url="nav.jsp"></c:import>

        <div class="content">
            <h1 class="anim">오늘통닭<br>매일통닭 파티 환영!</h1>
            <p class="anim">저렴하고 양많은, 그리고 알찬 오늘통닭이 기다리고 있습니다!!
            매일통닭 파티에 참여하세요!
            </p>
            <a href="#" class="btn anim">Join Now</a>
        </div>
        <img src="resources/image/character_del.png" class="feature-img anim">
    </div>
</body>
</html>