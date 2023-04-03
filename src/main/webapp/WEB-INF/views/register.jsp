<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <style>
        .container {
            background-image: url("TaxRegister.jpeg");
        }
    </style>
</head>
<body class="container">
<div style="background: black;padding: 30px;opacity: 1 !important;">
    <h1>Register <i>here</i></h1>
    <form method="POST" action="${pageContext.request.contextPath}/register">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        <input type="submit" value="Register" style="margin-left: 43%;">
    </form>
    <br>
    <p>Back to <a href="/login">login</a></p>
</div>
</body>
</html>
