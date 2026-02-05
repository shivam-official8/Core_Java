<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<body>

<h2>Admin Product Panel</h2>

<a href="/admin/products/add">Add Product</a>

<c:forEach var="p" items="${products}">
    <div>
            ${p.name} | ₹${p.price} | Stock: ${p.instock}

        <a href="/admin/products/edit/${p.id}">Edit</a>
        <a href="/admin/products/delete/${p.id}">Delete</a>
    </div>
</c:forEach>

</body>
</html>
