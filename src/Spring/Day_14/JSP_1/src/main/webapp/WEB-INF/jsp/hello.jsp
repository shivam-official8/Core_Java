<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://jakarta.apache.org/taglibs/standard-1.2" prefix="c" %>--%>
<html>
<head>
    <title>My First JSP</title>
</head>
<body>
<h1>Hello, JSP World!</h1>

<%-- Java code block --%>
<%
    String message = "Welcome to JSP with Spring Boot!";
%>
<p><%= message %></p>

<%-- Using JSTL and Expression Language --%>
<c:set var="user" value="Shivam"/>
<p>Hello, ${user}!</p>
</body>
</html>
