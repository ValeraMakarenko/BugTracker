<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<c:import url="/header"></c:import>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account page</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
<div class="success">
    Dear <strong>${user}</strong>, Welcome to Account Page.
    <br/>
    <a href="<c:url value="/logout" />">Logout</a>
</div>
</body>
</html>
