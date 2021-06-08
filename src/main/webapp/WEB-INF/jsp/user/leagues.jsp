<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<head>

</head>
<body>
<h1>Wybierz swoją ulubioną ligę!</h1>
<body>
<form:form action="" method="post" modelAttribute="league">
    <c:forEach items="${leagues}" var="l">
        <form:radiobutton path="name" value="${l.getName()}"/>${l.getName()} <br>
    </c:forEach>
    <input type="submit" value="Wybierz swoją ligę!">
</form:form>

</body>

</body>
