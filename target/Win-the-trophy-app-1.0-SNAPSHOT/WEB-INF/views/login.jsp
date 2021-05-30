<%--
  Created by IntelliJ IDEA.
  User: canary
  Date: 20.05.2021
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Login</h1>
<form:form method="post" modelAttribute="user">
    Login: <form:input path="name"/>
    Password: <form:password path="password"/>
    <input type="submit" value="Login!"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form:form>
<br>
Nie masz jeszcze konta? <br>
<a href="/wtt/register">Zarejestruj się!</a>
</body>
</html>
