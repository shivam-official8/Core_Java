<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Your Cart</title>
</head>
<body>

<jsp:include page="common/header.jsp" />

<h2>Your Cart</h2>

<c:if test="${empty cartItems}">
    <p>Cart is empty</p>
</c:if>

<c:if test="${not empty cartItems}">
    <table border="1" cellpadding="8">
        <tr>
            <th>Product ID</th>
            <th>Quantity</th>
        </tr>

        <c:forEach items="${cartItems}" var="c">
            <tr>
                <td>${c.productId}</td>
                <td>${c.quantity}</td>
            </tr>
        </c:forEach>
    </table>

    <br/>

    <form action="/customer/orderNow" method="post">
        <button>Order Now</button>
    </form>


</c:if>
<form action="/home" method="get">
    <button>Home Page</button>
</form>
</body>
</html>
