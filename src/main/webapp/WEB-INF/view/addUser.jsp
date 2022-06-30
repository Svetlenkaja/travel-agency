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
                            <spring_form:checkboxes items="${roles}" itemLabel="name" path="roles" />

                        </div>
                    <% } %>
               <br/>
                    <div>
                        <spring_form:label path="username">Имя пользователя <b>*</b></spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" path="username"/>
                    </div>
                    <div>
                        <spring_form:label path="surname">Фамилия <b>*</b></spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" path="surname"/>
                    </div>
                    <div>
                        <spring_form:label path="name">Имя</spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" path="name"/>
                    </div>
                    <div>
                        <spring_form:label path="email">Электронная почта <b>*</b></spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" path="email"/>
                    </div>
                   <div>
                       <spring_form:label path="phone">Телефон</spring_form:label>
                       <br/>
                       <spring_form:input class="input-text" path="phone"/>
                   </div>
                    <div>
                        <spring_form:label path="password">Пароль <b>*</b></spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" type="password" path="password"  />
                    </div>
                    <div>
                        <spring_form:label path="passwordConfirm">Подтверждение пароля <b>*</b></spring_form:label>
                        <br/>
                        <spring_form:input class="input-text" type="password" path="passwordConfirm" />
                    </div>
                    <div>
                        <input class="input-text" type="submit" value="Зарегистрироваться"/>
                    </div>
               <div class="message">
                   <c:if test='${param.containsKey("errorDuplicate")}'>
                       Пользователь с таким userName уже существует!
                   </c:if>
                   <c:if test='${param.containsKey("errorEmpty")}'>
                       Не все обязательные поля заполнены!
                   </c:if>
                   <c:if test='${param.containsKey("errorConfirmPassword")}'>
                       Пароль не подвержден!
                   </c:if>
                   <c:if test='${param.containsKey("userNotSaved")}'>
                       Произошла ошибка при сохранении пользователя. Обратитесь к администратору!
                   </c:if>
               </div>
            </div>
        </spring_form:form>
    </body>
</html>