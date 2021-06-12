<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<br>
<sec:authorize access="hasRole('ADMIN')">
    <h3>Jesteś adminem</h3><br>
    Pobierz dane!<br>
    Zaaktualizuj dane o zespołach:
    <a href="/admin/leagues">Wszystkie dostępne ligi</a> <br>


</sec:authorize>
<h1>Twój ulubiony zespół</h1>

<img src="${user.getFavTeam().getCrestUrl()}"/><br>
${user.getFavTeam().getName()} <br>

<a href="/user/chooseleague">Zmień zespół</a>

<h3>Statystki</h3>
Punkty: ${user.getFavTeam().getPoints()} <br>
Mecze wygrane: ${user.getFavTeam().getMatchesWon()} <br>
Mecze przegrane: ${user.getFavTeam().getMatchesLost()} <br>
Remisy : ${user.getFavTeam().getMatchesDraw()} <br>
Gole zdobyte : ${user.getFavTeam().getGoals()} <br>
Gole stracone : ${user.getFavTeam().getLostGoals()} <br>

<c:choose>
    <c:when test="${not empty user.getFavTeam().getLeague().getId()}">
<a href="/user/leagueteams/${user.getFavTeam().getLeague().getId()}">Aktualizuj</a>
    </c:when>
    <c:otherwise><br> Nie można pobrać danych o statystykach</c:otherwise>
</c:choose>
<c:choose>
    <c:when test="${not empty user.getFavTeam().getLeague().getMatchDaysInTotal()} ">
<h3>Czy Twój zespół miał szansę na wygraną w kolejce numer: </h3>
<form method="post" action="/user/couldwin">
    <select name="matchday">
    <c:forEach begin="1" end="${user.getFavTeam().getLeague().getMatchDaysInTotal()}" var="md" step="1">
            <option value="${md}">${md}</option>
    </c:forEach>
    </select>
    <input type="submit" value="Sprawdź">
</form>
    </c:when>
    <c:otherwise>
        <br>
        Nie można teraz pobrać danych o możliwości wygranej, zgłoś do aministratora
    </c:otherwise>
</c:choose>
</body>
</html>
