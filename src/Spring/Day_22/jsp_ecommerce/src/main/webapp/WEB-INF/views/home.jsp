<%--<%@ page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Home</title>--%>

<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            background-color: #f4f6f8;--%>
<%--            margin: 0;--%>
<%--            padding: 20px;--%>
<%--        }--%>

<%--        h2 {--%>
<%--            text-align: center;--%>
<%--        }--%>

<%--        .top-bar {--%>
<%--            display: flex;--%>
<%--            justify-content: space-between;--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>

<%--        .products {--%>
<%--            display: grid;--%>
<%--            grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));--%>
<%--            gap: 20px;--%>
<%--        }--%>

<%--        .product-card {--%>
<%--            background: #fff;--%>
<%--            padding: 15px;--%>
<%--            border-radius: 8px;--%>
<%--            box-shadow: 0 2px 6px rgba(0,0,0,0.1);--%>
<%--        }--%>

<%--        .product-card h4 {--%>
<%--            margin: 0 0 10px;--%>
<%--        }--%>

<%--        .price {--%>
<%--            font-weight: bold;--%>
<%--            color: #2e7d32;--%>
<%--        }--%>

<%--        a.logout {--%>
<%--            text-decoration: none;--%>
<%--            color: white;--%>
<%--            background: #d32f2f;--%>
<%--            padding: 8px 14px;--%>
<%--            border-radius: 4px;--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>

<%--<body>--%>

<%--<div class="top-bar">--%>
<%--    <h3>Welcome to E-Commerce</h3>--%>
<%--    <a href="/logout" class="logout">Logout</a>--%>
<%--</div>--%>

<%--<h2>All Products</h2>--%>

<%--<div class="products">--%>
<%--    <c:forEach var="product" items="${products}">--%>
<%--        <div class="product-card">--%>
<%--            <h4>${product.name}</h4>--%>
<%--            <p>${product.description}</p>--%>
<%--            <p class="price">₹ ${product.price}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<%--</div>--%>

<%--<c:if test="${empty products}">--%>
<%--    <p style="text-align:center;">No products available</p>--%>
<%--</c:if>--%>

<%--</body>--%>
<%--</html>--%>



<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <style>
        body { font-family: Arial; background: #f5f5f5; padding: 20px; }
        .container { max-width: 1000px; margin: auto; }
        h1 { margin-bottom: 10px; }

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
        }

        th { background: #eee; }

        .btn {
            padding: 8px 12px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin-right: 5px;
        }

        .btn-danger { background: #dc3545; }
        .btn-dark { background: #343a40; }
    </style>
</head>

<body>
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

                <!-- ADMIN EXTRA COLUMN -->
                <c:if test="${roles.toString().contains('ROLE_ADMIN')}">
                    <th>Actions</th>
                </c:if>
            </tr>

            <c:forEach items="${products}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td>${p.instock}</td>

                    <!-- ADMIN ACTIONS -->
                    <c:if test="${roles.toString().contains('ROLE_ADMIN')}">
                        <td>
                            <form action="/admin/deleteProduct/${p.id}" method="post" style="display:inline;">
                                <button class="btn btn-danger">Delete</button>
                            </form>
<%--                            <form action="/admin/updateProduct/${p.id}" method="post" style="display:inline;">--%>
                            <a href="admin/updateProductPage/${p.id}" class="btn btn-primary">Update</a>
<%--                            </form>--%>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>

    <!-- ADMIN PANEL -->
    <c:if test="${roles.toString().contains('ROLE_ADMIN')}">
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

