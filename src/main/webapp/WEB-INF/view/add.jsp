<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Tour</title>
    <link type="text/css" rel="stylesheet" href="resources/css/common.css" />
    <script type="text/javascript" src="scripts/tour.js"></script>
</head>
<body>

<form class="form" action="/addTour">
    <div class="div-center" >
        <h3>Новый тур</h3>
    </div>
    <div>
        <c:forEach items="${tourTypes}" var="tourType" >
            <input class="input-text" type="radio" name="radioTourType" onclick="chooseTour(this);" value=${tourType.code}> ${tourType.name}
        </c:forEach>
    </div>
    <div id="div-info" class="div-center"  style="display: none">
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
        <label>Количество ночей:
            <input class="input-text input-text-small" type="text" name="numberOfNights" ><br />
        </label>
        <label>Стоимость:
            <input class="input-text input-text-small" type="text" name="cost" ><br />
        </label>
        <label>Тип питания:
            <select class="input-text" name="foodType" required>
                <option disabled value="" selected>Выберите тип питания</option>
                <c:forEach items = "${foodTypes}" var = "foodType" >
                    <option value = ${foodType.code} >
                            ${foodType.shortname} (${foodType.name})
                    </option>
                </c:forEach>
            </select><br />
        </label>
        <div>
            <label>Тип транспорта: </Br>
                <c:forEach items="${transportTypes}" var="transportType">
                    <input class="input-text" type="radio" name="transportType" value=${transportType.code}> ${transportType.name}
                </c:forEach>
            </label>
        </div>
    </div>
    <div class="div-center">
        <button disabled id="save-button" style="color: crimson; margin-top: 5px;" type="submit" value="Submit">Сохранить тур</button>
        <button onclick="location.href='home'">Назад</button>
    </div>
    <div id="div-saved" class="div-saved">
        <c:if test="${saved == true}"  >
            <label>Тур успешно сохранен!</label>
        </c:if>
    </div>
</form>
</body>
</html>