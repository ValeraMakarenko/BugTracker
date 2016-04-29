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

<div class="form-container">

    <h1><spring:message code="project.edit.title"/></h1>

    <form:form method="POST" modelAttribute="projectDto" class="form-horizontal">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="nameProject"><spring:message code="project.nameProject"/>*</label>
                <div class="col-md-7">
                    <form:input type="text" path="nameProject" required="true" id="nameProject" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="nameProject" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="url"><spring:message code="project.url"/></label>
                <div class="col-md-7">
                    <form:input type="url" path="url" id="url" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="url" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="managerId"><spring:message code="project.managers"/></label>
                <div class="col-md-7">
                    <form:select path="managerId" items="${managers}" multiple="false" itemValue="id" itemLabel="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="managerId" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="typeProjectId"><spring:message code="project.typeProjects"/></label>
                <div class="col-md-7">
                    <form:select path="typeProjectId" items="${typeProjects}" readonly="true" multiple="false" itemValue="id" itemLabel="type" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="typeProjectId" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="<spring:message code="project.edit.submit"/>" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form:form>
</div>
</body>
</html>
