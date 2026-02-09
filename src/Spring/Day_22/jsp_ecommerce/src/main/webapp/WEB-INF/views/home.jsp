<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="isAdmin"
       value="${pageContext.request.isUserInRole('ROLE_ADMIN')}" />

<c:set var="isCustomer"
       value="${pageContext.request.isUserInRole('ROLE_CUSTOMER')}" />

<html>
<head>
    <title>Home</title>

    <style>
        body {
            font-family: Arial;
            background: #f5f5f5;
            padding: 20px;
        }

        .container {
            max-width: 1000px;
            margin: auto;
        }

        h1 {
            margin-bottom: 10px;
        }

        .products, .admin-panel {
            background: #fff;
            padding: 15px;
            margin-top: 20px;
            border-radius: 6px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background: #eee;
        }

        .btn {
            padding: 6px 10px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            border: none;
            cursor: pointer;
        }

        .btn-danger { background: #dc3545; }
        .btn-dark { background: #343a40; }
    </style>
</head>

<body>

<!-- COMMON HEADER -->
<jsp:include page="common/header.jsp" />

<div class="container">

    <h1>Welcome to E-Commerce</h1>

    <!-- PRODUCTS -->
    <div class="products">
        <h2>Products</h2>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>In Stock</th>

                <c:if test="${isCustomer}">
                    <th>Add To Cart</th>
                </c:if>

                <c:if test="${isAdmin}">
                    <th>Actions</th>
                </c:if>
            </tr>

            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td>${p.instock}</td>

                    <!-- CUSTOMER : ADD TO CART -->
                    <c:if test="${isCustomer}">
                        <td>
                            <form action="${pageContext.request.contextPath}/customer/addToCart" method="post">
                                <input type="hidden" name="productId" value="${p.id}" />
                                <input type="number"
                                       name="quantity"
                                       min="1"
                                       max="${p.instock}"
                                       value="1"
                                       required />
                                <br/><br/>
                                <button class="btn">Add To Cart</button>
                            </form>
                        </td>
                    </c:if>

                    <!-- ADMIN : ACTIONS -->
                    <c:if test="${isAdmin}">
                        <td>
                            <form action="/admin/deleteProduct/${p.id}"
                                  method="post"
                                  style="display:inline;">
                                <button class="btn btn-danger">Delete</button>
                            </form>

                            <a href="/admin/updateProductPage/${p.id}"
                               class="btn">Update</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>

        <c:if test="${empty products}">
            <p style="text-align:center;">No products available</p>
        </c:if>
    </div>

    <!-- ADMIN PANEL -->
    <c:if test="${isAdmin}">
        <div class="admin-panel">
            <h2>Admin Panel</h2>

            <a href="/admin/add-product-page" class="btn">Add Product</a>
            <a href="/admin/users" class="btn btn-dark">View Users</a>
            <a href="/admin/orders" class="btn btn-dark">View Orders</a>
        </div>
    </c:if>

</div>
</body>
</html>
