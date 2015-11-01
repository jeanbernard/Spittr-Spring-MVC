<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spittles</title>
</head>
<body>
	<h1>Spittle</h1>
	<ul>

		<li id="spittle_<c:out value ="spittle.id" />">
			<div class="spittleMessage">
				<h3>
					<c:out value="${spittleId.message}" />
				</h3>
			</div>
			<div>
				<p>
					<c:out value="${spittleId.time}" />
				</p>
			</div>
	</ul>
</body>
</html>