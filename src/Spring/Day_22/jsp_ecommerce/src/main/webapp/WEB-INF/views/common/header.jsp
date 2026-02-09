<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="isCustomer"
       value="${pageContext.request.isUserInRole('ROLE_CUSTOMER')}" />

<style>
    .top-bar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background: #343a40;
        padding: 10px 20px;
        color: white;
        margin-bottom: 20px;
    }

    .top-bar a, .top-bar button {
        margin-left: 10px;
        background: #dc3545;
        color: white;
        border: none;
        padding: 6px 12px;
        border-radius: 4px;
        cursor: pointer;
        text-decoration: none;
    }

    .cart-btn { background: #198754; }
</style>

<div class="top-bar">
    <strong>E-Commerce</strong>

    <div>
        <c:if test="${isCustomer}">
            <a href="/customer/cart" class="cart-btn">View Cart</a>
        </c:if>

        <form action="${pageContext.request.contextPath}/logout" method="post"
              style="display:inline;">
            <button type="submit">Logout</button>
        </form>
    </div>
</div>
