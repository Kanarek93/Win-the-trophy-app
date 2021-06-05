<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<table>
    <thead>
    <tr>
        <td> Id</td>
        <td> Name</td>
        <td> Code</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${ligi}" var="liga">
        <tr>
            <td>${liga.getId()}</td>
            <td>${liga.getName()}</td>
            <td>${liga.getCode()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
