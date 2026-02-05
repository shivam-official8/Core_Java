<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<body>

<h2>Your Cart</h2>

<c:forEach var="item" items="${cartItems}">
    Product ID: ${item.productId}<br/>
    Quantity: ${item.quantity}

    <form action="/cart/update" method="post">
        <input type="hidden" name="productId" value="${item.productId}"/>
        <input type="number" name="quantity" value="${item.quantity}"/>
        <button>Update</button>
    </form>
    <hr/>
</c:forEach>

<form action="/order/now" method="post">
    <button>Order Now</button>
</form>

</body>
</html>
