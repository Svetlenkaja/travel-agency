<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="user">
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
<div class="menu">
    <a href="${pageContext.request.contextPath}/home">Главная</a>
    |
    <a href="${pageContext.request.contextPath}/createTour">Создать тур</a>
    |
    <a href="${pageContext.request.contextPath}/tours">Каталог</a>
    |
    <a href="${pageContext.request.contextPath}/find">Подобрать тур</a>
    |
    <a href="${pageContext.request.contextPath}/users">Пользователи</a>
    |
    <a href="${pageContext.request.contextPath}/personalTours">Мои туры</a>
</div>