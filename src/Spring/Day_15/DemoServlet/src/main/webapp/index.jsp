<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Addition Problem!" %>
</h1>
<br/>

<form action="add">
    Enter Number 1: <input type="number" name="num1"> <br>
    Enter Number 2: <input type="number" name="num2"> <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>