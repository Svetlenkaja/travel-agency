<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="resources/css/common.css" />
</head>
    <body>
    <h3>Регистрация</h3>
        <spring_form:form method="POST" action="/addUser" modelAttribute="user">
            <table>
                <tr>
                    <td><spring_form:label path="role">Role</spring_form:label></td>
                     <td>  <spring_form:select path="role">
                            <spring_form:option value="NONE" label="--- Select ---"/>
                            <spring_form:options items="${roles}" itemValue="code" itemLabel="name"/>
                        </spring_form:select>
                     </td>
                </tr>
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
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </spring_form:form>
    </body>
</html>