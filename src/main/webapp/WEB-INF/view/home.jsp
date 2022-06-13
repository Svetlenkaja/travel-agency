<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Главная</title>
    <link type="text/css" rel="stylesheet" href="resources/css/home.css" />
</head>
    <body>
            <div class="content">
            <div style="float: right; color: crimson " >
                <%
                    if (request .getSession().getAttribute("userName") != null) {
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
                <a href="${pageContext.request.contextPath}/createTour">Создать тур</a>
                |
                <a href="${pageContext.request.contextPath}/tours">Каталог</a>
                |
                <a href="${pageContext.request.contextPath}/users">Пользователи</a>
                |
                <a href="${pageContext.request.contextPath}/personalTours">Мои туры</a>
            </div>
        </div>
    </body>
</html>