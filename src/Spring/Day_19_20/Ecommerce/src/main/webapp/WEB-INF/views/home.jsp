<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.ecommerce.entity.Users" %>
<%
    Users user = (Users) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2>Welcome, <%= user.getName() %>!</h2>
<p>Username: <%= user.getUsername() %></p>
<p>Role: <%= user.getRole() %></p>

<a href="<%= request.getContextPath() %>/logout">Logout</a>
</body>
</html>
