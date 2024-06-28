<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img src="./resources/img/pikachu.jpg" alt="Pikachu"/>
<img src="./resources01/img/pikachu.jpg" alt="Pikachu"/>
<img src="${pageContext.request.contextPath}/resources/img/pikachu.jpg" alt="Pikachu"/>
<img src="${pageContext.request.contextPath}/resources01/img/pikachu.jpg" alt="Pikachu"/>
</body>
</html>
