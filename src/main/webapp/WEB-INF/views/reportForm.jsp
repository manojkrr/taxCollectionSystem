<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Add Report</title>
</head>
<body>
<h1>Add Report</h1>
<form method="post" action="<c:url value='/report/save'/>">
    <label>User:</label>
    <select name="user.id">
        <c:forEach items="${users}" var="user">
            <option value="${user.id}">${user.username}</option>
        </c:forEach>
    </select><br/>
    <label>Tax Year:</label>
    <input type="text" name="taxYear"/><br/>
    <label>File Path:</label>
    <input type="text" name="filePath"/><br/>
    <input type="submit" value="Save"/>
</form>
<a href="/report">Cancel</a>
</body>
</html>
