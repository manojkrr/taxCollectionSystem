<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <style>
        .container {
            background-image: url("TaxPhoto.jpeg");
        }
    </style>
</head>
<body class="container">
<div style="background: black;padding: 30px;opacity: 1 !important;">
    <h1>Welcome to the Dashboard</h1>
    <p class="h3"><i>${message}</i></p>
    <hr>
<%--    <img class="tax-photo" src="${pageContext.request.contextPath}/TaxPhoto.jpeg" alt="TaxPhoto">--%>
    <p>Click <a href="/login">here</a> to log in.</p>
    <p>Don't have an account? Click <a href="/register">here</a> to register.</p>
    <p>To see all reports, Click <a href="/report">here</a></p>
</div>
</body>
</html>
