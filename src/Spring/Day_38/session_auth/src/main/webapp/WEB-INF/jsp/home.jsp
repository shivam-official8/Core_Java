<h1>Welcome, ${pageContext.request.userPrincipal.name}<h1/>
<form action="/logout" method="post">
    <button type="submit">Logout</button>
</form>