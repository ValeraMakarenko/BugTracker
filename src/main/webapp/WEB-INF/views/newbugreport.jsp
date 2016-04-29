<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/header"></c:import>
<head>
    <style>
        .descr { visibility: hidden; }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Bug Report Form</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>

<div class="form-container">

    <h1>New Bug Report Form</h1>

    <c:if test="${errorEmpty != null}">
        <div class="alert alert-danger">
            <p>Enter correct!</p>
        </div>
    </c:if>

    <form:form method="POST" modelAttribute="bugReportDto" class="form-horizontal">

        <div class="descr">
            <form:input type="text" path="reporterId" id="reporterId" class="form-control input-sm"/>
            <form:input type="text" path="projectId" id="projectId" class="form-control input-sm"/>
        </div>
        <div class="has-error">
            <form:errors path="reporterId" class="help-inline"/>
            <form:errors path="projectId" class="help-inline"/>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="title">Title</label>
                <div class="col-md-7">
                    <form:input type="text" path="title" id="title" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="title" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="summary">Summary</label>
                <div class="col-md-7">
                    <form:input type="text" path="summary" id="summary" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="summary" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="stepsToReproduce">Steps to reproduce</label>
                <div class="col-md-7">
                    <form:input type="text" path="stepsToReproduce" id="stepsToReproduce" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="stepsToReproduce" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="actualResult">Actual result</label>
                <div class="col-md-7">
                    <form:input type="text" path="actualResult" id="actualResult" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="actualResult" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="expectedResult">Expected result</label>
                <div class="col-md-7">
                    <form:input type="text" path="expectedResult" id="expectedResult" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="expectedResult" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="statusId">Statuses</label>
                <div class="col-md-7">
                    <form:select path="statusId" items="${statuses}" multiple="false" readonly="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="statusId" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="priorityId">Priorities</label>
                <div class="col-md-7">
                    <form:select path="priorityId" items="${priorities}" multiple="false" itemValue="id" itemLabel="type" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="priorityId" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="assignedId">Assigned</label>
                <div class="col-md-7">
                    <form:select path="assignedId" items="${assignedId}" multiple="false" itemValue="id" itemLabel="firstName" class="form-control input-sm"/>
                    <div class="has-error">
                        <form:errors path="assignedId" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Create bug report" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form:form>
</div>
</body>
</html>