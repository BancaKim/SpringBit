<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스프링MVC</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/memberlist.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
</head>

<body>

  <div class="main-container">
       	<c:import url="../nav.jsp"/>

<!-- 게시판 리스트 -->
<div class="wrapper">
<div class="title" align="center">👨회원관리 게시판👩</div>
<p align="right">회원 수 : ${requestScope.listcount}</p>
<div class="board-container">
<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
    <table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <tr>
                <th scope="col" class="px-6 py-3">
                    ID
                </th>
                <th scope="col" class="px-6 py-3">
                    비밀번호
                </th>
                <th scope="col" class="px-6 py-3">
                    이메일
                </th>
                <th scope="col" class="px-6 py-3">
                    유저이름
                </th>
                <th scope="col" class="px-6 py-3">
                    주민등록번호
                </th>
               	<th scope="col" class="px-6 py-3">
                    자기소개
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.userlist}" var="ul">
       	<tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700">
          <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
			<a href="${pageContext.request.contextPath}/login/memberView?user_id=${ul.user_id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">
				${ul.user_id}
			</a>
          </th>
		  <td class="px-6 py-4">
					${ul.user_pw}
			</td>
		  <td class="px-6 py-4">
				${ul.email}
			</td>
		  <td class="px-6 py-4">
				${ul.user_name}
			</td>	
		  <td class="px-6 py-4">
				${ul.ssn}
			</td>
		  <td class="px-6 py-4">
				${ul.introduction}
			</td>
		</tr>
		</c:forEach>
		
		<tr>
		<td colspan=6 align="center">
				<c:choose>
					<c:when test="${requestScope.page<=1}">
						[이전]&nbsp;
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/login/memberList?page=${requestScope.page-1}">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>

				<c:forEach var="a" begin="${requestScope.startpage}" end="${requestScope.endpage}" step="1">
					<c:choose>
						<c:when test="${a==requestScope.page}">
						[${a}]
						</c:when>
						<c:otherwise>
							<a href="./memberList?page=${a}">[${a}]</a>&nbsp;
						</c:otherwise>
						</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${requestScope.page>=requestScope.maxpage}">
						[다음]
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/login/memberList?page=${requestScope.page+1}">[다음]</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</div>
</div>
</div>
</div>
</body>
</html>