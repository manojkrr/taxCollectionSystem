<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>New Business</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <style>
        .container {
            background-image: url("TaxPhoto.jpeg");
        }
    </style>
</head>
<body class="container">
<div style="background: black;padding: 30px;opacity: 1 !important;color: white">
<h1>New Business</h1>
<form method="post" action="/businesses">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save" /></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
