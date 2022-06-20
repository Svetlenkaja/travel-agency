<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="resources/css/common.css" />
    <link type="text/css" rel="stylesheet" href="resources/css/login.css" />
</head>
    <body>
        <spring_form:form cssClass="form" method="POST" action="/addUser" modelAttribute="user">
           <div class="content">
                <div>
                    <h3 class="div-center">Регистрация</h3>
                </div>
    <%--                <tr>--%>
    <%--                    <td><spring_form:label path="role">Role</spring_form:label></td>--%>
    <%--                     <td>  <spring_form:select path="role">--%>
    <%--                            <spring_form:option value="NONE" label="--- Select ---"/>--%>
    <%--                            <spring_form:options items="${roles}" itemValue="code" itemLabel="name"/>--%>
    <%--                        </spring_form:select>--%>
    <%--                     </td>--%>
    <%--                </tr>--%>
                    <div>
                        <spring_form:label path="username">Username</spring_form:label>
                        <spring_form:input class="input-text" path="username"/>
                    </div>
                    <div>
                        <spring_form:label path="surname">Surname</spring_form:label>
                        <spring_form:input class="input-text" path="surname"/>
                    </div>
                    <div>
                        <spring_form:label path="name">Name</spring_form:label>
                        <spring_form:input class="input-text" path="name"/>
                    </div>
                    <div>
                        <spring_form:label path="email">Email</spring_form:label>
                        <spring_form:input class="input-text" path="email"/>
                    </div>
                    <div>
                        <spring_form:label path="password">Password</spring_form:label>
                        <spring_form:input class="input-text" type="password" path="password"  />
                    </div>
                    <div>
                        <spring_form:label path="passwordConfirm">Confirm password</spring_form:label>
                        <spring_form:input class="input-text" type="password" path="passwordConfirm" />
                    </div>
                    <div>
                        <input class="input-text" type="submit" value="Submit"/>
                    </div>
            </div>
        </spring_form:form>
    </body>
</html>