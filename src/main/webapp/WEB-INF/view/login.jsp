<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
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
        .input-text{
            margin-bottom: 10px;
        }
        .form{
            max-width: 300px;
            padding: 20px;
            margin: 0 auto;
            background-color: #fff;
        }
    </style>
</head>
<body>
<form class="form" method="post">
    <div>
        <div class="content">
            <div>
                <h2>Авторизация</h2>
            </div>
<%--            <c:if test="${loginError != null}">--%>
<%--                <div style="color: crimson">--%>
<%--                    <p><c:out value="${loginError}"/></p>--%>
<%--                </div>--%>
<%--            </c:if>--%>
            <label>Пользователь:
                <br/>
                <input class="input-text" type="text" name="name" placeholder="пользователь"><br />
            </label>
            <label>Пароль:
                <br/>
                <input class="input-text" type="password" name="pass" placeholder="пароль" ><br />
            </label>
            <button type="submit">Войти</button>
        </div>
    </div>
</form>
</body>
</html>