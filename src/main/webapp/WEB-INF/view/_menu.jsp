<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="menu">
    <a href="${pageContext.request.contextPath}/home">Главная</a>
    |
    <a href="${pageContext.request.contextPath}/tours">Каталог</a>
<%--    |--%>
<%--    <a href="${pageContext.request.contextPath}/find">Подобрать тур</a>--%>
    <% if (request.isUserInRole("MANAGER") || request.isUserInRole("ADMIN")) { %>
    |
    <a href="${pageContext.request.contextPath}/tours/createTour">Создать тур</a>
    |
    <a href="${pageContext.request.contextPath}/bookings">Заказы</a>
    <% } %>
    <% if (request.isUserInRole("ADMIN")) { %>
    |
    <a href="${pageContext.request.contextPath}/users">Пользователи</a>
    <% } %>
</div>
<div class="menu">
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
            <b>Пользователь : ${pageContext.request.userPrincipal.name}</b>
            <% if (request.isUserInRole("CLIENT")) { %>
            |
            <a href="<c:url value="/bookings/myBooking" />">Мой профиль</a>
            |
            <a href="<c:url value="/bookings/myBooking" />">Мои заказы</a>
            |
            <% } %>
            <a href="<c:url value="/logout" />">Выйти</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/login">Войти</a>
            |
            <a href="${pageContext.request.contextPath}/register">Регистрация</a>
        </c:otherwise>
    </c:choose>
</div>
