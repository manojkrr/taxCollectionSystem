<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Show Business</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <style>
        .container {
            background-image: url("TaxPhoto.jpeg");
        }
    </style>
</head>
<body class="container">
<div style="background: black;padding: 30px;opacity: 1 !important;color: white">
    <h1>${business.name}</h1>
    <p><strong>Address:</strong> ${business.address}</p>
    <p><a href="/businesses/edit/${business.id}">Edit</a></p>
    <form method="post" action="/businesses/delete/${business.id}">
        <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this business?')" />
    </form>
</div>
</body>
</html>
