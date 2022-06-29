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
        <spring_form:form cssClass="form" method="POST" action="${url_param}" modelAttribute="user">
           <div class="content">
                <div>
                    <h3 class="div-center">Регистрация</h3>
                </div>
                    <% if (request.isUserInRole("ADMIN")) { %>
                        <div>
                            <spring_form:checkboxes items="${roles}" path="roles" />
                            <br/>
                        </div>
                    <% } %>
    <%--                            <spring_form:options items="${roles}" itemValue="code" itemLabel="name"/>--%>

                    <div>
                        <spring_form:label path="username">Имя пользователя</spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" path="username"/>
                    </div>
                    <div>
                        <spring_form:label path="surname">Фамилия</spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" path="surname"/>
                    </div>
                    <div>
                        <spring_form:label path="name">Имя</spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" path="name"/>
                    </div>
                    <div>
                        <spring_form:label path="email">Электронная почта</spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" path="email"/>
                    </div>
                   <div>
                       <spring_form:label path="phone">Телефон</spring_form:label>
                       <br/>
                       <spring_form:input class="input-text" path="phone"/>
                   </div>
                    <div>
                        <spring_form:label path="password">Пароль</spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" type="password" path="password"  />
                    </div>
                    <div>
                        <spring_form:label path="passwordConfirm">Подтверждение пароля</spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" type="password" path="passwordConfirm" />
                    </div>
                    <div>
                        <input class="input-text" type="submit" value="Зарегистрироваться"/>
                    </div>
            </div>
        </spring_form:form>
    </body>
</html>