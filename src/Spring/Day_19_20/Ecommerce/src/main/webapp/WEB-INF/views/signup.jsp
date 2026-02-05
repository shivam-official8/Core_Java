<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h2>Sign Up</h2>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/signup" method="post">
    <label>Name:</label>
    <input type="text" name="name" required/><br/><br/>

    <label>Username:</label>
    <input type="text" name="username" required/><br/><br/>

    <label>Password:</label>
    <input type="password" name="password" required/><br/><br/>

    <button type="submit">Sign Up</button>
</form>

<p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login</a></p>
</body>
</html>
