<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:import url="/header"></c:import>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>
<div class="ttable">
    <div class="generic-container">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead"><spring:message code="project.details.title"/></span></div>
            <table id="table" class="table table-hover">
                <thead>
                <tr>
                    <th><spring:message code="project.nameProject"/></th>
                    <th><spring:message code="project.url"/></th>
                    <th><spring:message code="project.managers"/></th>
                    <th><spring:message code="project.typeProjects"/></th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${project.nameProject}</td>
                        <td>${project.url}</td>
                        <td>${project.manager}</td>
                        <td>${project.typeProject}</td>
                    </tr>
                </tbody>
            </table><br>
            <a href="<c:url value='/new-bug-report-${project.id}' />" class="btn btn-success custom-width">
                <spring:message code="project.details.new.bug"/>
            </a>
            <a href="<c:url value='/bugreport-list-${project.id}' />" class="btn btn-success custom-width">
                <spring:message code="project.details.bug.list"/>
            </a>
        </div>
    </div>
</div>

</body>
</html>