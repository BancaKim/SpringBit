<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String context = request.getContextPath(); %>
<form action="<%=context %>/studentView" method="post">
이름 : <input type=text name="studentName"/><br/>
나이 : <input type=text name="studentAge"/><br/>
학년 : <input type=text name="studentGrade"/><br/>
반 : <input type=text name="studentClass"/><br/>
<input type="submit" value="전송"/>
</form>
</body>
</html>