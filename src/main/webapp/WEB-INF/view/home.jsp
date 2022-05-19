<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
    <style>
        body {
            background-color: #f5f5f5;
            padding: 2px;
            display: flex;
            flex-direction: column;
        }
        .content {
            flex: 1 0 auto;
            text-align: center;
        }
    </style>
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
        <a href="${pageContext.request.contextPath}/add">Создать тур</a>
        |
        <a href="${pageContext.request.contextPath}/find">Подобрать тур</a>
        |
        <a href="${pageContext.request.contextPath}/list">Каталог</a>
    </div>
</div>
</body>
</html>