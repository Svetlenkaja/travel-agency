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
        <div>Выберите тип сортировки
            <select class="input-text" name="sortedType">
                <option value = 0 <c:if test="${sortedValue==0}"> selected </c:if> >По номеру </option>
                <option value = 1 <c:if test="${sortedValue==1}"> selected </c:if> >По дате отправления</option>
                <option value = 2 <c:if test="${sortedValue==2}"> selected </c:if> >По стоимости с учетом скидки</option>
                <option value = 3 <c:if test="${sortedValue==2}"> selected </c:if> >По количеству ночей</option>
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
            <th>№</th><th>Тип тура</th><th>Страна</th><th>Дата отправления</th><th>Количество ночей</th><th>Тип питания</th><th>Транспорт</th>
            <th>Стоимость</th><th>Скидка</th><th>С учетом скидки</th><th>Статус</th>
        </tr>
        <c:forEach items="${tours}" var="tour" >
            <tr>
                <td><a href="<c:url value="/tours/tour/${tour.id}"/>">${tour.id}</a></td>
                <td>${tour.type.classifier.name}</td>
                <td>${tour.country.name}</td>
                <td>${tour.dateOfDeparture}</td>
                <td>${tour.numberOfNights}</td>
                <td>${tour.food.classifier.name}</td>
                <td>${tour.transport.name}</td>
                <td>${tour.price}</td>
                <td>${tour.discount} %</td>
                <td>${tour.discountPrice}</td>
                <td>${tour.state.classifier.name}</td>
                <td>
                <c:if test="${tour.stateCode < 3}">
                    <% if (request.isUserInRole("CLIENT")) { %>
                    <a href="<c:url value="/bookings/${tour.id}"/>">Заказать</a>
                    <% } %>
                </c:if>
                </td>
                <td>
                    <c:if test="${tour.stateCode < 2}">
                    <% if (request.isUserInRole("MANAGER")) { %>
                        <a href="<c:url value="/tours/hot/${tour.id}"/>">Изменить</a>
                    <% } %>
                </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    </br>
    <div>
        <c:choose>
            <c:when test="${currPage > 0}">
                <span><a href="<c:url value="/tours/${currPage-1}${sortedParam}"/>">Предыдущая</a></span>
            </c:when>
        </c:choose>
        <c:forEach var="i" begin="0" end="${lastPage-1 }" >
            <span><a href="<c:url value="/tours/${i}${sortedParam}"/>">${i+1 }</a></span>   	<!-- Displaying Page No -->
        </c:forEach>
        <c:choose>
            <c:when test="${currPage < lastPage}">
                <span><a href="<c:url value="/tours/${currPage+1}${sortedParam}"/>">Следующая</a></span>
            </c:when>
        </c:choose>
    </div>
</body>
</html>
