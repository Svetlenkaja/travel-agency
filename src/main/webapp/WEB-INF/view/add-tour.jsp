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
    <script type="text/javascript" src="scripts/tour.js"></script>
</head>
<body>

<spring_form:form class="form" action="/addTour" modelAttribute="tour">
    <div class="div-center" >
        <h3>Новый тур</h3>
    </div>
    <spring_form:label path="tourType">Тип тура</spring_form:label>
    <br />
    <c:forEach items = "${tourTypes}" var = "type" >
        <spring_form:radiobutton path="tourType" value="${type.code}" label="${type.name}"/>
    </c:forEach>
<%--    <div>--%>
<%--        <c:forEach items="${tourTypes}" var="tourType" >--%>
<%--            <input class="input-text" type="radio" name="radioTourType" onclick="chooseTour(this);" value=${tourType.code}> ${tourType.name}--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
    <div id="div-info" class="div-center"  style="display: block">
        <label>Дата отправления:
            <input class="input-text" type="date" name="calendar"> <br />
        </label>
        <div id="div-rest" style="display: none">
            <label>Страна:
<%--                <input class="input-text" type="text" name="country" ><br />--%>
            </label>
            <label>Курорт:
<%--                <input class="input-text" type="text" name="resort" ><br />--%>
            </label>
        </div>
        <spring_form:label path="numberOfNights">Количество ночей</spring_form:label>
        <spring_form:input class="input-text input-text-small" path="numberOfNights"/>
        <br />
        <spring_form:label path="cost">Стоимость</spring_form:label>
        <spring_form:input class="input-text input-text-small" path="cost"/>
        <br />
        <spring_form:label path="foodType">Тип питания</spring_form:label>
        <spring_form:select path="foodType">
            <spring_form:option value="3|0" label="Выберите тип питания"/>
            <c:forEach items = "${foodTypes}" var = "foodType" >
                <spring_form:option value="${foodType.code}" label="${foodType.name}"/>
            </c:forEach>
<%--            <spring_form:options items="${foodTypes}" itemValue="code" itemLabel="name"/>--%>
        </spring_form:select>
        <br />
        <spring_form:label path="transportType">Тип транспорта</spring_form:label>
        <br />
        <c:forEach items = "${transportTypes}" var = "transport" >
            <spring_form:radiobutton path="transportType" value="${transport.code}" label="${transport.name}"/>
        </c:forEach>
    </div>
    <div class="div-center">
        <button id="save-button" style="color: crimson; margin-top: 5px;" type="submit" value="Submit">Сохранить тур</button>
        <button onclick="location.href='home'">Назад</button>
    </div>
    <div id="div-saved" class="div-saved">
        <c:if test="${saved == true}"  >
            <label>Тур успешно сохранен!</label>
        </c:if>
    </div>
</spring_form:form>
</body>
</html>