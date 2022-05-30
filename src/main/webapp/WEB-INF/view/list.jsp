<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="resources/css/catalog.css" />
</head>
<body>
<div class="content">
    <div style="float: right; color: crimson " >
        <%
            if (request.getSession().getAttribute("userName") != null) {
        %>
        Пользователь: ${userName}
        <%
            }
        %>
    </div>
    <div >
        <h1> Туристическая фирма </h1>
    </div>
    <div style="padding: 5px;">
        <a href="${pageContext.request.contextPath}/add">Создать тур</a>
        |
        <a href="${pageContext.request.contextPath}/find">Подобрать тур</a>
        |
        <a href="${pageContext.request.contextPath}/list">Каталог</a>
    </div>
</div>
<form class="form" action="${pageContext.request.contextPath}/list" modelAttribute="tours">
    <div>
        <select class="input-text" name="sortedType">
            <option value = 0 >Выберите тип сортировки </option>
            <option value = 1 >дате отправления</option>
            <option value = 2 >стоимости</option>
        </select>
        <button  style="color: crimson; margin-top: 5px;" type="submit" value="Submit">Сортировать</button>
    </div>
</form>
<table>
    <tr>
        <th>Тип тура</th>
        <th>Дата отправления</th>
        <th>Количество ночей</th>
        <th>Тип питания</th>
        <th>Стоимость</th>
        <th>Страна</th>
    </tr>
    <c:forEach items="${tours}" var="tour" >
        <tr>
            <td>${tour.tourType}</td>
            <td>${tour.dateOfDeparture}</td>
            <td>${tour.numberOfNights}</td>
            <td>${tour.foodType}</td>
            <td>${tour.cost}</td>
            <td>
                <c:if test="${tour.tourType=='REST'}">
                    ${tour.country}
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
