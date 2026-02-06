<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Users</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            padding: 30px;
        }

        h2 {
            text-align: center;
        }

        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            background: white;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background: #333;
            color: white;
        }

        tr:nth-child(even) {
            background: #f2f2f2;
        }

        .back {
            display: block;
            width: 150px;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background: #333;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .back:hover {
            background: #555;
        }
    </style>
</head>
<body>

<h2>All Users</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Username</th>
        <th>Role</th>
    </tr>

    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.username}</td>
            <td>${u.role}</td>
        </tr>
    </c:forEach>
</table>

<a href="/home" class="back">Back to Admin Home</a>

</body>
</html>
