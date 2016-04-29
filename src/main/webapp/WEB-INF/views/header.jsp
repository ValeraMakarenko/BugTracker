<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/"><i class="glyphicon glyphicon-cloud"></i>
                <spring:message code="header.title"/>
            </a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="divider-vertical"></li>
                <c:if test="${user != 'anonymousUser'}">
                    <li><a href="/newProject"><spring:message code="header.createProject"/></a></li>
                    <li><a href="/projectlist"><spring:message code="header.all.projects"/></a></li>
                    <li><a href="/bugreportlist"><spring:message code="header.all.bugs"/></a></li>
                </c:if>

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${user == 'anonymousUser'}">
                    <li><a href="/login"><spring:message code="header.authorization"/></a></li>
                    <li><a href="/newUser"><spring:message code="header.registration"/></a></li>
                </c:if>
                <c:if test="${user != 'anonymousUser'}">
                    <li><a href="/account"><i class="glyphicon glyphicon-user"></i>${user}</a></li>
                </c:if>
                <li>
                        <a href="?lang=en">en</a>
                </li>
                <li>
                        <a href="?lang=ru">ru</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

