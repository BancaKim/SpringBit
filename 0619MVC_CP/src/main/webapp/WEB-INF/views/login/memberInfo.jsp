<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>매일통닭</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/boardlist.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
</head>

<body>
  <div class="main-container">
              	<c:import url="../nav.jsp"/>
	<div class="content">
		<div align="center" style="font-weight:900; font-size:x-large;">👨회원 상세정보👩</div>
		
		<div class="relative overflow-x-auto shadow-md sm:rounded-lg mt-10">
			 <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
				  <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            		<tr>
             		   <th scope="col" class="px-6 py-3">구분</th>
               		   <th scope="col" class="px-6 py-3">내용</th>       
					</tr>       
					</thead>
				<tbody>
		            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
								<td>ID</td>
				<td>${requestScope.userdata.user_id}</td>
		</tr>
		            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
			<td>Password</td>
			<td>${requestScope.userdata.user_pw}</td>
		</tr>
		            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
			<td>E-mail</td>
			<td>${requestScope.userdata.email}</td>
		</tr>
		            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
			<td>이름</td>
			<td>${requestScope.userdata.user_name}</td>
		</tr>
		            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
			<td>주민번호</td>
			<td>${requestScope.userdata.ssn}</td>
		</tr>
		            <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
			<td>자기소개</td>
			<td>${requestScope.userdata.introduction}</td>
		</tr>
				</tbody>
		</table>
	</div>
	<div class="btn_del">
	<button type="button" class="text-white bg-gradient-to-r from-red-400 via-red-500 to-red-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 shadow-lg shadow-red-500/50 dark:shadow-lg dark:shadow-red-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 mb-2 mt-5" onclick="location.href='memberDelete?user_id=${requestScope.userdata.user_id}'">회원삭제</button>			
	</div>
	</div>
	</div>
</body>
</html>