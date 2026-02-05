<html>
<body>

<h2>Edit Product</h2>

<form action="/admin/products/update" method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    Name: <input name="name" value="${product.name}"/><br/>
    Price: <input name="price" value="${product.price}"/><br/>
    Stock: <input name="instock" value="${product.instock}"/><br/>
    <button>Update</button>
</form>

</body>
</html>
