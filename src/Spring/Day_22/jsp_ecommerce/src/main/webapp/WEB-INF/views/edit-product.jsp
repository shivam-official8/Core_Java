<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Edit Product</title>
    <style>
        form {
            width: 400px;
            margin: auto;
        }
        input, textarea {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
        }
        button {
            background: #4CAF50;
            color: white;
            padding: 10px;
            width: 100%;
            border: none;
        }
    </style>
</head>

<body>
<jsp:include page="common/header.jsp" />
<h2 align="center">Update Product</h2>

<form action="/admin/updateProduct" method="post">

    <input type="hidden" name="id" value="${product.id}" />

    <input type="text" name="name" value="${product.name}" placeholder="Name" required />

    <textarea name="description" required>${product.description}</textarea>

    <input type="number" step="0.01" name="price" value="${product.price}" required />

    <input type="number" name="instock" value="${product.instock}" required />

    <button type="submit">Update Product</button>

</form>

</body>
</html>
