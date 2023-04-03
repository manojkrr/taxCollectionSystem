<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Reports</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <style>
        .container {
            background-image: url("TaxPhoto.jpeg");
        }
    </style>
</head>
<body class="container">
<div style="background: black;padding: 30px;opacity: 1 !important;color: white">
<h1>List of Reports</h1>
<p><a href="/dashboard">Back To Dashboard</a></p>
<p>Add a <a href="/report/add" style="color: yellow">New Report</a>?</p>
<hr>
    <table border="1" cellpadding="5" cellspacing="5" style="color: white">
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
                <td><a href="/report/delete/${report.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
