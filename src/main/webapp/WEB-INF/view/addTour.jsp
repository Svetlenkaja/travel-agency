<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Tour</title>
    <link type="text/css" rel="stylesheet" href="resources/css/common.css" />
    <link type="text/css" rel="stylesheet" href="resources/css/form.css" />
    <script type="text/javascript" src="scripts/tour.js"></script>
</head>
<body>
    <div class="content">
        <jsp:include page="_header.jsp" />
        <jsp:include page="_menu.jsp" />
    </div>
    <spring_form:form class="form" action="/addTour" modelAttribute="tour">
    <div class="div-center" >
        <h3>Новый тур</h3>
    </div>

    <div id="div-info" class="div-center"  style="display: block">
        <spring_form:label path="tourType">Тип тура</spring_form:label>
        <br />
        <c:forEach items = "${tourTypes}" var = "type" >
            <spring_form:radiobutton path="type" value="${type}" label="${type.getClassifier().getName()}"/>
        </c:forEach>
        <br />
        <spring_form:label path="dateOfDeparture">Дата отправления</spring_form:label>
        <spring_form:input class="input-text" path="dateOfDeparture" type="date" name="calendar"/>
        <br />
        <spring_form:label path="country">Страна</spring_form:label>
        <spring_form:select path="country">
            <spring_form:option value="0" label="Выберите страну"/>
            <c:forEach items = "${countries}" var = "country" >
                <spring_form:option value="${country.id}" label="${country.getName()}"/>
            </c:forEach>
        </spring_form:select>
        <br>
        <spring_form:label path="numberOfNights">Количество ночей</spring_form:label>
        <spring_form:input class="input-text input-text-small" path="numberOfNights"/>
        <br />
        <spring_form:label path="cost">Стоимость</spring_form:label>
        <spring_form:input class="input-text input-text-small" path="cost"/>
        <br />
        <spring_form:label path="food">Тип питания</spring_form:label>
        <spring_form:select path="food">
            <spring_form:option value="0" label="Выберите тип питания"/>
            <c:forEach items = "${foodTypes}" var = "foodType" >
                <spring_form:option value="${foodType}" label="${foodType.getClassifier().getName()}"/>
            </c:forEach>
        </spring_form:select>
        <br />
        <spring_form:label path="transport">Тип транспорта</spring_form:label>
        <br />
        <c:forEach items = "${transportTypes}" var = "transport" >
            <spring_form:radiobutton path="transport" value="${transport}" label="${transport.getName()}"/>
        </c:forEach>
    </div>
    <div class="div-center">
        <button id="save-button" style="color: crimson; margin-top: 5px;" type="submit" value="Submit">Сохранить тур</button>
        <button onclick="location.href='home'">Назад</button>
    </div>
</spring_form:form>
</body>
</html>