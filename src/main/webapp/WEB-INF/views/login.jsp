<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <style>
        .container {
            background-image: url("TaxLogin.jpeg");
        }
    </style>
</head>
<body class="container">
<div style="background: black;padding: 30px;opacity: 1 !important;">
    <h1>Login <i>here</i></h1>
    <form method="POST" action="${pageContext.request.contextPath}/login">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Login" style="margin-left: 44%;">
    </form>
    <br>
    <p>Don't have an account? Click <a href="/register">here</a> to register.</p>
</div>
</body>
</html>
