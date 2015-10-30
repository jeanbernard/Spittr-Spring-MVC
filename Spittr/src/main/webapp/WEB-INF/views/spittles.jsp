<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spittles</title>
</head>
<body>
	<h1>Recent Spittles</h1>
	<ul>
		<c:forEach items="${spittleList}" var="spittle">
			<li id="spittle_<c:out value ="spittle.id" />">
				<div class="spittleMessage">
					<h3> <c:out value="${spittle.message}" /> </h3> 
				</div>
		</c:forEach>
	</ul>
</body>
</html>