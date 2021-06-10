<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="header.jsp"%>>

<h1>Wybierz ulubiony zespół</h1>
<c:choose>
<c:when test="${not empty teams}">
    <form:form action="/user/chooseteam" method="post" modelAttribute="team">
        <c:forEach items="${teams}" var="t">
            <form:radiobutton path="name" value="${t.getName()}" />${t.getName()} <br>
            <form:hidden path="id" value="${t.getId()}"/>
        </c:forEach>
        <input type="submit" value="Wybierz swój ulubiony zespół!">
    </form:form>
</c:when>
<c:otherwise>
    Coś poszło nie tak, liga nie ma żadnych zespołów.
    <a href="/user">Powrót do strony głównej</a>
</c:otherwise>
</c:choose>
</body>
</html>
