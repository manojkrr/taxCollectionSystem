<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Reports</title>
</head>
<body>
<h1>List of Reports</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>User</th>
        <th>Tax Year</th>
        <th>File Path</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reports}" var="report">
        <tr>
            <td>${report.id}</td>
            <td>${report.user.username}</td>
            <td>${report.taxYear}</td>
            <td>${report.filePath}</td>
            <td><a href="<c:url value='/report/delete/${report.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<c:url value='/report/add'/>">Add Report</a>
</body>
</html>