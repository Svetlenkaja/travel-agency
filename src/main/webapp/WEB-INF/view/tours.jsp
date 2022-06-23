<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css" rel="stylesheet" href="resources/css/header.css" />
    <link type="text/css" rel="stylesheet" href="resources/css/common.css" />
    <link type="text/css" rel="stylesheet" href="resources/css/catalog.css" />
</head>
<body>
    <div class="content">
        <jsp:include page="_header.jsp" />
        <jsp:include page="_menu.jsp" />
    </div>
    <form class="form" action="${pageContext.request.contextPath}/tours" modelAttribute="tours">
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
            <th>№</th><th>Тип тура</th><th>Страна/курорт</th><th>Дата отправления</th><th>Количество ночей</th><th>Тип питания</th><th>Транспорт</th>
            <th>Стоимость</th><th>Статус</th><th></th><th></th>
        </tr>
        <c:forEach items="${tours}" var="tour" >
            <tr>
                <td><a href="<c:url value="/tour/${tour.id}"/>">${tour.id}</a></td>
                <td>${tour.type.classifier.name}</td>
                <td>${tour.country.name}</td>
                <td>${tour.dateOfDeparture}</td>
                <td>${tour.numberOfNights}</td>
                <td>${tour.food.classifier.name}</td>
                <td>${tour.transport.name}</td>
                <td>${tour.cost}</td>
                <td>${tour.costWithDiscount}</td>
                <td>${tour.stateType.name}</td>
                <% if (request.isUserInRole("CLIENT")) { %>
                    <td><a href="<c:url value="/booking/${tour.id}"/>">Заказать</a></td>
                <% } %>
                <% if (request.isUserInRole("MANAGER")) { %>
                    <td><a href="<c:url value="/tour/setHot/${tour.id}"/>">Горящий</a></td>
                <% } %>
            </tr>
        </c:forEach>
    </table>
    <div><a href="${pageContext.request.contextPath}/createTour">Создать тур</a></div>
</body>
</html>
