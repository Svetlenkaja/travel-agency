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
        <a href="${pageContext.request.contextPath}/home">Главная</a>
        |
        <a href="${pageContext.request.contextPath}/find">Подобрать тур</a>
        |
        <a href="${pageContext.request.contextPath}/personalTours">Мои туры</a>
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
            <th>№</th>
            <th>Тип тура</th>
            <th>Страна/курорт</th>
            <th>Дата отправления</th>
            <th>Количество ночей</th>
            <th>Тип питания</th>
            <th>Транспорт</th>
            <th>Стоимость</th>
            <th>Статус</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${tours}" var="tour" >
            <tr>
                <td><a href="<c:url value="/tour/${tour.id}"/>">${tour.id}</a></td>
                <td>${tour.type.name}</td>
                <td>
<%--                    <c:if test="${tour.tourType.code==1}">--%>
<%--                        ${tour.hotel.resort.country.name}/${tour.hotel.resort.name}--%>
<%--                    </c:if>--%>
                </td>
                <td>${tour.dateOfDeparture}</td>
                <td>${tour.numberOfNights}</td>
                <td>${tour.food.name}</td>
                <td>${tour.transport.name}</td>
                <td>${tour.cost}</td>
                <td>${tour.stateType.name}</td>
            <td><a href="<c:url value="/booking?id=${tour.id}"/>">Забронировать</a></td>
            <td><a href="<c:url value="/tour?id=${tour.id}"/>">Изменить</a></td>
            </tr>
        </c:forEach>
    </table>
    <div><a href="${pageContext.request.contextPath}/createTour">Создать тур</a></div>
</body>
</html>
