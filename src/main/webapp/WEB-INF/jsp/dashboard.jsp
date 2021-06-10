<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>>
<br>
<h1>Twój ulubiony zespół</h1>

<img src="${user.getFavTeam().getCrestUrl()}"/><br>
${user.getFavTeam().getName()} <br>

<a href="/user/chooseleague">Zmień zespół</a>


</body>
</html>
