<%--
  Created by IntelliJ IDEA.
  User: D
  Date: 28.02.2020
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<div >Table of meals</div>
<table>
    <thead>
        <tr>
            <th>dateTime</th>
            <th>description</th>
            <th>calories</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="meal" items="${meals}">
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealTo"/>
            <tr>
                <td>${fn:replace(meal.dateTime,'T',' ')}</td>
                <td>${meal.description}</td>

                <td>
                    <c:choose>
                        <c:when test="${meal.excess }">
                            <span style="color: red">${meal.calories}</span>

                        </c:when>
                        <c:otherwise>
                            <span style="color: green">${meal.calories}</span>

                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>


</body>
</html>
