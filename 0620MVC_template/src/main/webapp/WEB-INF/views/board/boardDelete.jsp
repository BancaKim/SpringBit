<%@ page language="java" contentType="text/html; charset=EUC-KR"%>

<html>
<head>
<title>MVC 게시판</title>
</head>
<body>
<form name="deleteForm" action="${pageContext.request.contextPath}/board/boardDeleteAction?num=${num}" method="post">
<table border=1>
<tr>
	<td>
		<font size=2>글 비밀번호 : </font>
	</td>
	<td>
		<input name="BOARD_PASS" type="password">
	</td>
</tr>
<tr>
	<td colspan=2 align=center>
		<a href="javascript:deleteForm.submit()">삭제</a>
		&nbsp;&nbsp;
		<a href="javascript:history.go(-1)">돌아가기</a>
	</td>
</tr>
</table>
</form>
</body>
</html>