<%--
  Created by IntelliJ IDEA.
  User: canary
  Date: 08.06.2021
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wybierz swoją ulubioną ligę!</title>
</head>
<body>
    <form:form action="chosenLeague" method="post">
        <c:forEach items="${leagues}" var="l">
            <form:radiobuttons path="leagueName" items="${leagues}" >${l.getName()}</form:radiobuttons>
        </c:forEach>
        <input type="submit" value="Wybierz swoją ligę!">
    </form:form>

</body>
</html>
