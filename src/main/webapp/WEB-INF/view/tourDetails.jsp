<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Details</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/common.css" />
</head>
    <body>
    <div class="content">
        <jsp:include page="_header.jsp" />
        <jsp:include page="_menu.jsp" />
            <div>
                <h3>Подробная информация о туре </h3>
                <div>Код: ${tour.id}</div>
                <div>Тип тура: ${tour.type.classifier.name}</div>
                <div>Страна: ${tour.country.name}</div>
                <div>Дата отправления: ${tour.dateOfDeparture}</div>
                <div>Тип питания: ${tour.food.classifier.name}</div>
                <div>Транспорт: ${tour.transport.name}</div>
                <div>Стоимость: ${tour.price}</div>
                <div>Скидка: ${tour.discount}</div>
                <div>Стоимость с учетом скидки: ${tour.discountPrice}</div>
                <div>Статус: ${tour.state.classifier.name}</div>
            </div>
    </div>
    </body>
</html>