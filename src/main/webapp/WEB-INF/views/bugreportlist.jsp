<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import url="/header"></c:import>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>


</head>

<body>
<div class="ttable">
    <div class="generic-container">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Bug reports </span></div>
            <table id="table" class="table table-hover">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Summary</th>
                    <th>Steps to reproduce</th>
                    <th>Actual result</th>
                    <th>Expected result</th>
                    <th>Reporter</th>
                    <th>Assigned</th>
                    <th>Status</th>
                    <th>Priority</th>
                    <th>Start bug report</th>
                    <th width="100"></th>
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${bugReports}" var="bugReports">
                    <tr>
                        <td>${bugReports.title}</td>
                        <td>${bugReports.summary}</td>
                        <td>${bugReports.stepsToReproduce}</td>
                        <td>${bugReports.actualResult}</td>
                        <td>${bugReports.expectedResult}</td>
                        <td>${bugReports.reporter}</td>
                        <td>${bugReports.assigned}</td>
                        <td>${bugReports.status}</td>
                        <td>${bugReports.priority}</td>
                        <td>${bugReports.date}</td>
                        <td><a href="<c:url value='/edit-bugreport-${bugReports.id}' />" class="btn btn-success

custom-width">edit</a></td>
                        <td><a href="<c:url value='/delete-bugreport-${bugReports.id}' />" class="btn btn-danger

custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.0-rc2/js/bootstrap.min.js"></script>
<script src="jquery.tablesorter.min.js"></script>
<script src="jquery.tablesorter.widgets.min.js"></script>
<script>
    $(document).ready(function(){
        $(function(){
            $("#table").tablesorter(
                    {
                        theme : 'blue',

                        sortList : [[1,0],[2,0],[3,0]],

                        // header layout template; {icon} needed for some themes
                        headerTemplate : '{content}{icon}',

                        // initialize column styling of the table
                        widgets : ["columns"],
                        widgetOptions : {
                            // change the default column class names
                            // primary is the first column sorted, secondary is the second, etc
                            columns : [ "primary", "secondary", "tertiary" ]
                        }
                    });
        });
    });
</script>


</body>
</html>