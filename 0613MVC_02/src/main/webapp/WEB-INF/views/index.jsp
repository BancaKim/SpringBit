<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./studentView" name="student" method="Post">   <!-- get방식 -->
		<div>
			student id : <input type="text" name="studentId"/>
		</div>
		<div>
			<input type="submit" value="전송"/>
		</div>
	</form>

</body>
</html>