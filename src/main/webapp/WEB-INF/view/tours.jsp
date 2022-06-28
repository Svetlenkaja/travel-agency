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
        <% if (request.isUserInRole("MANAGER")) { %>
            <div><a href="${pageContext.request.contextPath}/tours/createTour">Создать тур</a></div>
        </br>
        <% } %>
        <tr>
            <th>№</th><th>Тип тура</th><th>Страна/курорт</th><th>Дата отправления</th><th>Количество ночей</th><th>Тип питания</th><th>Транспорт</th>
            <th>Стоимость</th><th>С учетом скидки</th><th>Статус</th>
        </tr>
        <c:forEach items="${tours}" var="tour" >
            <tr>
                <td><a href="<c:url value="/tours/${tour.id}"/>">${tour.id}</a></td>
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
                    <td><a href="<c:url value="/bookings/${tour.id}"/>">Заказать</a></td>
                <% } %>
                <% if (request.isUserInRole("MANAGER")) { %>
                    <td><a href="<c:url value="/tours/setHot/${tour.id}"/>">Горящий</a></td>
                <% } %>
            </tr>
        </c:forEach>
    </table>
    </br>
    <div>
        <c:choose>
            <c:when test="${currPage > 0}">
                <span><a href="<c:url value="/tours/${currPage-1}"/>">Предыдущая</a></span>
            </c:when>
        </c:choose>
        <c:forEach var="i" begin="0" end="${lastPage-1 }" >
            <span><a href="<c:url value="/tours/${i}"/>">${i+1 }</a></span>   	<!-- Displaying Page No -->
        </c:forEach>
        <c:choose>
            <c:when test="${currPage < lastPage}">
                <span><a href="<c:url value="/tours/${currPage+1}"/>">Следующая</a></span>
            </c:when>
        </c:choose>
    </div>
</body>
</html>
