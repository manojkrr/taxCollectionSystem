<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Business</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <style>
        .container {
            background-image: url("TaxPhoto.jpeg");
        }
    </style>
</head>
<body class="container">
<div style="background: black;padding: 30px;opacity: 1 !important;color: white">
    <h1>Edit Business</h1>
    <form method="post" action="/businesses/edit/${business.id}">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${business.name}" /></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" value="${business.address}" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
