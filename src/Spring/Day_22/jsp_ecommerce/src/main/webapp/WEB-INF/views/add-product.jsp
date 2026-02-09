<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f4f4;
            padding: 40px;
        }
        .card {
            max-width: 400px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 6px;
        }
        input, textarea {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
        }
        button {
            width: 100%;
            padding: 10px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
        }
    </style>
</head>

<body>
<jsp:include page="common/header.jsp" />
<div class="card">
    <h2>Add Product</h2>

    <form action="${pageContext.request.contextPath}/admin/addProduct" method="post">
        <input name="name" placeholder="Product Name" required/>
        <textarea name="description" placeholder="Description"></textarea>
        <input type="number" step="0.01" name="price" placeholder="Price" required/>
        <input type="number" name="instock" placeholder="In Stock" required/>

        <button type="submit">Add Product</button>
    </form>
    <form action="${pageContext.request.contextPath}/home" method="get">
    <button type="submit">Home</button>
    </form>
</div>
</body>
</html>
