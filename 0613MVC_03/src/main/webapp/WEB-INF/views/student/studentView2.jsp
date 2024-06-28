<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
<style>
body {
	display: flex;
	justify-content : center;
	align-items : center;
}
</style>
</head>
<body>

<table border="1">
	<tr>
	<td>id</td>	<td>${id}</td>
	</tr>
	<tr>
	<td>password</td><td>${password}</td>
	</tr>
	<tr>
	<td>email</td>	<td>${email}</td>
	</tr>
	<tr>
	<td>userName</td>	<td>${userName}</</td>
	</tr>
	<tr>
	<td>ssn</td>	<td>${ssn}</td>
	</tr>
	<tr>
	<td>birthYear</td>	<td>${birthYear}</td>
	</tr>
	<tr>
	<td>birthMonth</td>	<td>${birthMonth}</td>
	</tr>
	<tr>
	<td>birthDay</td>	<td>${birthDay}</td>
	</tr>
	<tr>
	<td>introduction</td>	<td>${introduction}</td>
	</tr>
</table>
</body>
</html>