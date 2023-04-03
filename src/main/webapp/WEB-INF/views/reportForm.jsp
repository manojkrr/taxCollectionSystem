<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Report</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <style>
        .container {
            background-image: url("TaxPhoto.jpeg");
        }
    </style>
</head>
<body class="container">
<div style="background: black;padding: 30px;opacity: 1 !important;">
    <h1>Add Report</h1>
    <form method="post" action="/report/save">
        <label>User:</label>
        <select name="user.id">
            <c:forEach items="${users}" var="user">
                <option value="${user.id}">${user.username}</option>
            </c:forEach>
        </select><br/><br>
        <label>Tax Year:</label>
        <input type="text" name="taxYear"/><br/><br>
        <label>File Path:</label>
        <input type="text" name="filePath"/><br/><br>
        <input type="submit" value="Save" style="margin-left: 40%;"/>
    </form>
    <a href="/report" style="margin-left: 30%;">Back to List</a>
</div>
</body>
</html>
