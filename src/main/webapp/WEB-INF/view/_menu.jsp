<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="menu">
    <a href="${pageContext.request.contextPath}/home">Главная</a>
    |
    <a href="${pageContext.request.contextPath}/tours">Каталог</a>
    |
    <a href="${pageContext.request.contextPath}/find">Подобрать тур</a>
    <% if (request.isUserInRole("ADMIN")) { %>
    |
    <a href="${pageContext.request.contextPath}/createTour">Создать тур</a>
    |
    <a href="${pageContext.request.contextPath}/users">Пользователи</a>
    <% } %>
</div>
<div class="menu">
    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name != null}">
            Пользователь : ${pageContext.request.userPrincipal.name}
            <% if (request.isUserInRole("CLIENT")) { %>
            |
            <%--            <a href="${pageContext.request.contextPath}/personalTours">Мои туры</a>--%>
            <a href="<c:url value="/personalTours" />">Мой профиль</a>
            |
            <a href="<c:url value="/personalTours" />">Мои туры</a>
            |
            <% } %>
            <%--            <a href="${pageContext.request.contextPath}/logout"> Выйти</a>--%>
            <a href="<c:url value="/logout" />">Выйти</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/login">Войти</a>
        </c:otherwise>
    </c:choose>
</div>
