<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false"%>
<html>
<head>
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
	<sf:form method="POST" commandName="user">
		First Name: <sf:input path="firstName" /><br />
		Last Name: <sf:input path="lastName" /><br />
		Username: <sf:input path="username" /><br />
		Password: <sf:password path="password" /><br />
		<input type="submit" value="Register" />
	</sf:form>
</body>
</html>