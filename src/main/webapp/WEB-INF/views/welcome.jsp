<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<c:import url="/header"></c:import>
<body>
	<div class="success">
		<div class="container">
			Greeting : ${greeting}
			This is a welcome page.
		</div>
	</div>
</body>
</html>