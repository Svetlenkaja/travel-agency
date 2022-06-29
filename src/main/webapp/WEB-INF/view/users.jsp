<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Пользователи</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="resources/css/header.css" />
    <link type="text/css" rel="stylesheet" href="resources/css/common.css" />
    <link type="text/css" rel="stylesheet" href="resources/css/catalog.css" />
</head>
<body>
    <div class="content">
        <jsp:include page="_header.jsp" />
        <jsp:include page="_menu.jsp" />
        <div>
            <h3>Пользователи</h3>
        </div>
    </div>
    <table>
        <tr>
            <th>Id</th>
            <th>Пользователь</th>
            <th>Электронная почта</th>
            <th>Роль</th>
            <th>ФИО</th>
            <th>Телефон</th>
            <th>Статус</th>
            <th></th>
        </tr>
            <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>${user.roles}</td>
                <td>${user.surname} ${user.name}</td>
                <td>${user.phone}</td>
                <td>${user.accountNonLocked}</td>
                <c:if test="${user.accountNonLocked}">
                    <td><a href="lockedUser/${user.id}">Заблокировать</a></td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
<br/>
    <% if (request.isUserInRole("ADMIN")) { %>
        <a href="${pageContext.request.contextPath}/createUser">Создать пользователя</a>
    <% } %>
</body>
</html>