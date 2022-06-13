<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="resources/css/common.css" />
</head>
    <body>
        <spring_form:form cssClass="form" method="POST" action="/addUser" modelAttribute="user">
            <div class="div-center" >
                <h3>Регистрация</h3>
            </div>
            <div class="content">
                <table>
    <%--                <tr>--%>
    <%--                    <td><spring_form:label path="role">Role</spring_form:label></td>--%>
    <%--                     <td>  <spring_form:select path="role">--%>
    <%--                            <spring_form:option value="NONE" label="--- Select ---"/>--%>
    <%--                            <spring_form:options items="${roles}" itemValue="code" itemLabel="name"/>--%>
    <%--                        </spring_form:select>--%>
    <%--                     </td>--%>
    <%--                </tr>--%>
                    <tr>
                        <td><spring_form:label path="surname">Surname</spring_form:label></td>
                        <td><spring_form:input path="surname"/></td>
                    </tr>
                    <tr>
                        <td><spring_form:label path="name">Name</spring_form:label></td>
                        <td><spring_form:input path="name"/></td>
                    </tr>
                    <tr>
                        <td><spring_form:label path="login">Login</spring_form:label></td>
                        <td><spring_form:input path="login"/></td>
                    </tr>
                    <tr>
                        <td><spring_form:label path="email">Email</spring_form:label></td>
                        <td><spring_form:input path="email"/></td>
                    </tr>
                    <tr>
                        <td><spring_form:label path="password">Password</spring_form:label></td>
                        <td><spring_form:input type="password" path="password"  /></td>
                    </tr>
                    <tr>
                        <td><spring_form:label path="passwordConfirm">Confirm password</spring_form:label></td>
                        <td>
                            <spring_form:input type="password" path="passwordConfirm" />
                        </td>
                    </tr>
    <%--                <tr>--%>
                            <%--                        <spring_form:errors path="password" />--%>
                            <%--                            ${passwordError}--%>
    <%--                </tr>--%>
                    <tr>
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                </table>
            </div>
        </spring_form:form>
    </body>
</html>