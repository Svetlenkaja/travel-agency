<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="resources/css/login.css" />
    <link type="text/css" rel="stylesheet" href="resources/css/common.css" />
</head>
<body>
    <div class="content">
        <jsp:include page="_header.jsp" />
        <jsp:include page="_menu.jsp" />
    </div>
    <form class="form" method="post" action="/login">
        <div class="content">
            <div>
                <h2>Авторизация</h2>
            </div>
            <label>Пользователь:
                <br/>
                <input class="input-text" type="text" name="username"><br />
            </label>
            <label>Пароль:
                <br/>
                <input class="input-text" type="password" name="password"><br />
            </label>
            <button class="input-text" type="submit">Войти</button>
            <div class="message">
                <c:if test='${param.containsKey("error")}'>
                    Invalid username and password.
                </c:if>
                <c:if test='${param.containsKey("logout")}'>
                    Logout Successful!
                </c:if>
            </div>
            <h4><a href="/createUser">Зарегистрироваться</a></h4>
        </div>
    </form>
</body>
</html>