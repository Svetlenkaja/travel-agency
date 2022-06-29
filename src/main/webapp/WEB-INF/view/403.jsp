<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>HTTP Status 403 - Access is denied</h1>

<c:choose>
    <c:when test="${empty username}">
        <h3>You do not have permission to access this page!</h3>
    </c:when>
    <c:otherwise>
        <h3>Username : ${username} <br/>
            You do not have permission to access this page!</h3>
    </c:otherwise>
</c:choose>
</body>
</br>
<a href="${pageContext.request.contextPath}/home">Вернуться на главную страницу</a>
</body>
</html>