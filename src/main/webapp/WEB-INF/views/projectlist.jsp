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
                <div class="panel-heading"><span class="lead"><spring:message code="project.list.title"/></span></div>
                <table id="table" class="table table-hover">
                    <thead>
                    <tr>
                        <th><spring:message code="project.nameProject"/></th>
                        <th><spring:message code="project.url"/></th>
                        <th><spring:message code="project.managers"/></th>
                        <th><spring:message code="project.typeProjects"/></th>
                        <th width="100"></th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${projects}" var="projects">
                        <tr>
                            <td>${projects.nameProject}</td>
                            <td>${projects.url}</td>
                            <td>${projects.manager}</td>
                            <td>${projects.typeProject}</td>
                            <td><a href="<c:url value='/details-project-${projects.id}' />" class="btn btn-success custom-width">
                                    <spring:message code="project.list.details"/>
                                </a>
                            </td>
                            <td><a href="<c:url value='/edit-project-${projects.id}' />" class="btn btn-success custom-width">
                                    <spring:message code="project.list.edit"/>
                                </a>
                            </td>
                            <td><a href="<c:url value='/delete-project-${projects.id}' />" class="btn btn-danger custom-width">
                                    <spring:message code="project.list.delete"/>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>