<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스프링MVC</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/setProduct.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
		<script>
		function modifyQuantity(item, change) {
			var input = document.getElementById(item);
			if (input.value==''){
				input.value=0;
			}
			var currentValue = parseInt(input.value);
			if (currentValue + change >= 0) {
				input.value = currentValue + change;
			}
		}
		</script>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.user_id == null || user_id ==''}">
			<script>
				alert("아이디를 입력하고 로그인해주세요.");
				location.href="${pageContext.request.contextPath}/home";
			</script>
		</c:when>
		<c:otherwise>
			<div class="main-container">
       		<c:import url="../nav.jsp"></c:import>
        
			<div class="board-container">
				<div class="title">Choose items</div>
				<div class="subtitle">
				구매를 원하는 품목을 선택해주세요.
				</div>

				<form class="fruits-container" name = "form1" method="post" action="${pageContext.request.contextPath}/basket/itemAddAction">
					<table>
						<tr>
							<td><input type="hidden" name="apple" value="사과">🍎사과</td>
							<td><button type="button" onclick="modifyQuantity('apple_num', -1)" class="text-gray-900 bg-gradient-to-r from-teal-200 to-lime-200 hover:bg-gradient-to-l hover:from-teal-200 hover:to-lime-200 focus:ring-4 focus:outline-none focus:ring-lime-200 dark:focus:ring-teal-700 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">-</button></td>
							<td>
								<input type="number" name="apple_num" id="apple_num" value=${sessionScope.itemMap['사과'] }>
							</td>
							<td><button type="button" onclick="modifyQuantity('apple_num', 1)" class="text-gray-900 bg-gradient-to-r from-red-200 via-red-300 to-yellow-200 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-red-100 dark:focus:ring-red-400 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">+</button></td>
						</tr>
						<tr>
							<td><input type="hidden" name="peer" value="배">🍐배</td>
							<td><button type="button" onclick="modifyQuantity('peer_num', -1)" class="text-gray-900 bg-gradient-to-r from-teal-200 to-lime-200 hover:bg-gradient-to-l hover:from-teal-200 hover:to-lime-200 focus:ring-4 focus:outline-none focus:ring-lime-200 dark:focus:ring-teal-700 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">-</button></td>
							<td>
								<input type="number" name="peer_num" id="peer_num" value=${sessionScope.itemMap['배'] }>
							</td>
						<td><button type="button" onclick="modifyQuantity('peer_num', 1)" class="text-gray-900 bg-gradient-to-r from-red-200 via-red-300 to-yellow-200 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-red-100 dark:focus:ring-red-400 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">+</button></td>
					</tr>
						<tr>
							<td><input type="hidden" name="mandarin" value="귤">🍊귤</td>
							<td><button type="button" onclick="modifyQuantity('mandarin_num', -1)" class="text-gray-900 bg-gradient-to-r from-teal-200 to-lime-200 hover:bg-gradient-to-l hover:from-teal-200 hover:to-lime-200 focus:ring-4 focus:outline-none focus:ring-lime-200 dark:focus:ring-teal-700 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">-</button></td>
							<td>
								<input type="number" name="mandarin_num" id="mandarin_num" value=${sessionScope.itemMap['귤'] }>
							</td>
							<td><button type="button" onclick="modifyQuantity('mandarin_num', 1)" class="text-gray-900 bg-gradient-to-r from-red-200 via-red-300 to-yellow-200 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-red-100 dark:focus:ring-red-400 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2">+</button></td>
					</tr>
						<tr>
							<td colspan="4" align="center">
							<input type=submit class="text-white bg-gradient-to-br from-purple-600 to-blue-500 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 font-large rounded-lg text-lg px-5 py-2.5 text-center me-2 mb-2 mt-10" value="담기"/>
							</td>
						</tr>
					</table>
					
				</form>
				</div>
				</div>
		</c:otherwise>
	</c:choose>
</body>
</html>