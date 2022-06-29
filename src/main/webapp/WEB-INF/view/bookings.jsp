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
        <h3>Заказы</h3>
    </div>
</div>
<table>
    <tr>
        <th>№ заказа</th><th>Клиент</th><th>Дата заказа</th><th></th><th>№ тура</th><th>Дата отправления</th><th>Количество ночей</th><th>Тип питания</th><th>Транспорт</th>
        <th>Стоимость</th><th>Сумма к оплате</th><th>Статус</th>
    </tr>
    <c:forEach items="${bookings}" var="booking" >
        <tr>
            <td>${booking.orderNumber}</td>
            <td>${booking.client.surname} ${booking.client.name}</td>
            <td>${booking.orderDate}</td>
            <td>${booking.status}</td>
            <td><a href="<c:url value="/tour/${booking.tour.id}"/>">${booking.tour.id}</a></td>
            <td>${booking.tour.dateOfDeparture}</td>
            <td>${booking.tour.discountPrice}</td>
            <td>${booking.totalCost}</td>
            <td>${booking.tour.stateType.name}</td>
            <td>
                <c:if test="${booking.statusCode == 1}">
                    <a href="<c:url value="/bookings/cancel/${booking.id}"/>">Аннулировать</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
