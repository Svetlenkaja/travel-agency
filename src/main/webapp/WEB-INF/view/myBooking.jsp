<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/header.css" />
    <link type="text/css" rel="stylesheet" href="/resources/css/common.css" />
    <link type="text/css" rel="stylesheet" href="/resources/css/catalog.css" />
</head>
<body>
<div class="content">
    <jsp:include page="_header.jsp" />
    <jsp:include page="_menu.jsp" />
    <div>
        <h3>Мои заказы</h3>
    </div>
</div>
<table>
    <tr>
        <th>№ заказа</th><th>Дата заказа</th><th>№ тура</th><th>Тип тура</th><th>Страна/курорт</th><th>Дата отправления</th><th>Количество ночей</th><th>Тип питания</th><th>Транспорт</th>
        <th>Стоимость</th><th>Сумма к оплате</th><th>Статус</th>
    </tr>
    <c:forEach items="${booking}" var="booking" >
        <tr>
            <td>${booking.orderNumber}</td>
            <td>${booking.orderDate}</td>
            <td><a href="<c:url value="/tours/tour/${booking.tour.id}"/>">${booking.tour.id}</a></td>
            <td>${booking.tour.type.classifier.name}</td>
            <td></td>
            <td>${booking.tour.dateOfDeparture}</td>
            <td>${booking.tour.numberOfNights}</td>
            <td>${booking.tour.food.classifier.name}</td>
            <td>${booking.tour.transport.name}</td>
            <td>${booking.tour.price}</td>
            <td>${booking.totalCost}</td>
            <td>${booking.tour.state.classifier.name}</td>
            <td>
                <c:if test="${booking.statusCode == 1}">
                    <a href="<c:url value="/bookings/payment/${booking.id}"/>">Оплатить</a>
                </c:if>
            </td>
            <td>
                <c:if test="${booking.statusCode == 1}">
                    <a href="<c:url value="/bookings/cancel/${booking.id}"/>">Отменить</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
