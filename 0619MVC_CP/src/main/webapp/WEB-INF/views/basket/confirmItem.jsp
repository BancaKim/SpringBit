<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/confirmItem.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
</head>
<body>
	<div class="main-container">
       	<c:import url="../nav.jsp"></c:import>
	<div class="board-container">
	   <div class="title">💲계산하기💱</div>
			<div class="subtitle">${user_id}님😊의 장바구니</div>
				<table>
				<tr>				
					<td>🍎사과</td>
					<td>${sessionScope.itemMap["사과"]}</td></tr>
				<tr>				
					<td>🍐배</td>
					<td>${sessionScope.itemMap["배"]}</td></tr>
				<tr>				
					<td>🍊귤</td>
					<td>${sessionScope.itemMap["귤"]}</td></tr>
				</table>
			<div>
			<a href="${pageContext.request.contextPath}/basket/setProduct"><button type="button" class="text-white bg-gradient-to-br from-pink-500 to-orange-400 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-pink-200 dark:focus:ring-pink-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">주문 페이지로</button></a>
			<a href="${pageContext.request.contextPath}/basket/goPayAction"><button type="button" class="text-white bg-gradient-to-br from-green-400 to-blue-600 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-green-200 dark:focus:ring-green-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">계산하러 가기</button></a>		
			</div>
			</div>
	</div>
    
</body>
</html>