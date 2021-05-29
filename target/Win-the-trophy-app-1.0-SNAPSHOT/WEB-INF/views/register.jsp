<%--
  Created by IntelliJ IDEA.
  User: canary
  Date: 20.05.2021
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Could my team win the trophy?</title>
</head>
<body>
    <h1>Register form</h1>
    <form:form method="post" modelAttribute="user">
        Login: <form:input path="name"/>
        Email: <form:input path="email"/>
        Password: <form:password path="password"/>
        <input type="submit" value="Register!"/>
    </form:form>
</body>
</html>
