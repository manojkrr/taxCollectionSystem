<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Business</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <style>
        .container {
            background-image: url("TaxPhoto.jpeg");
        }
    </style>
</head>
<body class="container">
<div style="background: black;padding: 30px;opacity: 1 !important;color: white">
    <h1>Businesses</h1>
    <p><a href="/businesses/new">New Business</a></p>
    <p><a href="/dashboard">Back To Dashboard</a></p>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="business" items="${businesses}">
            <tr>
                <td>${business.name}</td>
                <td>${business.address}</td>
                <td>
                    <a href="/businesses/${business.id}">Show</a>
                    <a href="/businesses/edit/${business.id}">Edit</a>
                    <form method="post" action="/businesses/delete/${business.id}">
                        <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this business?')" />
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
