<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Profile</title>
</head>
<body>
	<h1>Spittle Profile</h1>
	<c:out value="${user.username}"></c:out>
	<c:out value="${user.firstName}"></c:out>
	<c:out value="${user.lastName}"></c:out>
</body>
</html>