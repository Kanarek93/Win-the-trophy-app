<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
Jesteś zalogowany jako: <sec:authentication property="name"/> <br>
<form action="<c:url value="/logout"/>" method="post">
  <input class="fa fa-id-badge" type="submit" value="Wyloguj">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</sec:authorize>
