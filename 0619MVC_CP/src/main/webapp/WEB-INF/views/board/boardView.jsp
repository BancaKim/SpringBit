<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Banca@Dev</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/boardview.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.3.0/flowbite.min.js"></script>
</head>

<body>

  <div class="main-container">
        	<c:import url="../nav.jsp"></c:import>
<!-- 게시판 수정 -->
<div class="wrapper">
	<div class="title" align="center">🏬게시판 상세보기🚀</div>

<table>	
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목&nbsp;&nbsp;</div>
		</td>
		
		<td style="font-family:돋음; font-size:12">
		${requestScope.boarddata.BOARD_SUBJECT}
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td style="font-family:돋음; font-size:12">
			<table border=0 width=490 height=250 style="table-layout:fixed">
				<tr>
					<td valign=top style="font-family:돋음; font-size:12">
					${requestScope.boarddata.BOARD_CONTENT}
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">첨부파일</div>
		</td>
		<td style="font-family:돋음; font-size:12">
		
		<c:if test="${!(requestScope.boarddata.BOARD_FILE==null)}">
			<a href="${pageContext.request.contextPath}/boardupload/${requestScope.boarddata.BOARD_FILE}">
				${requestScope.boarddata.BOARD_FILE}
			</a>
		</c:if>
		</td>
	</tr>
	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	
	<tr align="center" valign="middle">
		<td colspan="5">
			<font size=2>
			<a href="${pageContext.request.contextPath}/board/boardReply?num=${requestScope.boarddata.BOARD_NUM}">
			[답변]
			</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/board/boardModify?num=${requestScope.boarddata.BOARD_NUM}">
			[수정]
			</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/board/boardDelete?num=${requestScope.boarddata.BOARD_NUM}">
			[삭제]
			</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/board/list">[목록]</a>&nbsp;&nbsp;
			</font>
		</td>
	</tr>
</table>
</div>
</div>
<!-- 게시판 수정 -->
</body>
</html>