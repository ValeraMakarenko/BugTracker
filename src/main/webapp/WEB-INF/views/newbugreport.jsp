<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/header"></c:import>

<body>

<div class="form-container">

    <h1>New Bug Report Form</h1>

    <form:form method="POST" modelAttribute="bugReport" class="form-horizontal">
        <%--<form:input type="text" path="reporterId" id="reporterId" class="form-control input-sm"/>--%>
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
                    <form:select path="statusId" items="${statuses}" multiple="false" itemValue="id" itemLabel="type" class="form-control input-sm"/>
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