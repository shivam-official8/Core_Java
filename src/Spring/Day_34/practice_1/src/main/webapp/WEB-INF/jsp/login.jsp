<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
  <h2>Login</h2>
  <c:if test="${not empty error}"><p style="color:red">${error}</p></c:if>
  <c:if test="${not empty message}"><p style="color:green">${message}</p></c:if>

  <form action="/perform_login" method="post">
    <input type="text"     name="username" placeholder="Username" /><br/>
    <input type="password" name="password" placeholder="Password" /><br/>
    <button type="submit">Login</button>
  </form>
  <a href="/signup">Register</a>
</body>
</html>