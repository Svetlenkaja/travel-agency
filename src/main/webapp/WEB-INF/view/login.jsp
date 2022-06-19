<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="resources/css/login.css" />
</head>
<body>
<%--<sec:authorize access="isAuthenticated()">--%>
<%--    <% response.sendRedirect("/"); %>--%>
<%--</sec:authorize>--%>

    <div>
        <div class="content">
            <div>
                <h2>Авторизация</h2>
            </div>
            <form class="form" method="post" action="/login">

            <label>Пользователь:
                <br/>
                <input class="input-text" type="text" name="username" placeholder="пользователь"><br />
            </label>
            <label>Пароль:
                <br/>
                <input class="input-text" type="password" name="password" placeholder="пароль" ><br />
            </label>
            <button type="submit">Войти</button>
            <div style="color: red">
                <c:if test='${param.containsKey("error")}'>
                    Invalid username and password.
                </c:if>
                <c:if test="${param.logout}">
                    You have been logged out.
                </c:if>
            </div>
            <h4><a href="/createUser">Зарегистрироваться</a></h4>
            </form>
        </div>
    </div>

</body>
</html>