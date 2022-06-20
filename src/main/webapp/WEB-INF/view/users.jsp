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
        <div>
            <h3>Пользователи</h3>
        </div>
    </div>
    <table>
        <tr><th>Id</th><th>Role</th><th>Name</th><th>Email</th><th>Login</th><th>Edit</th><th>Delete</th></tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><a href="<c:url value="/user?id=${user.id}"/>">${user.id}</a></td>
                <td>${user.role.name}</td>
                <td>${user.surname} ${user.name}</td>
                <td>${user.email}</td>
                <td>${user.login}</td>
                <td><a href="edituser/${user.id}">Изменить</a></td>
                <td><a href="deleteuser/${user.id}">Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
<br/>
<a href="${pageContext.request.contextPath}/createUser">Создать пользователя</a>
</body>
</html>