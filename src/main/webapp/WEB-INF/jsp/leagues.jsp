<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="header.jsp"%>
<br>
<h1>Wybierz ulubioną ligę</h1>

<c:choose>
    <c:when test="${not empty leagues}">
        <form:form action="" method="post" modelAttribute="league">
            <c:forEach items="${leagues}" var="l">
            <form:radiobutton path="name" value="${l.getName()}"/>${l.getName()} <br>
            </c:forEach>
            <input type="submit" value="Wybierz swoją ligę!">
        </form:form>
    </c:when>
    <c:otherwise>
        Coś poszło nie tak, nie ma żadnej ligi.
    </c:otherwise>
</c:choose>

</body>
</html>
