<%@ page import="by.svetlenkaja.constant.FoodType" %>
<%@ page import="by.svetlenkaja.constant.TransportType" %>
<%@ page import="by.svetlenkaja.constant.TourType" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    pageContext.setAttribute("tourTypes", TourType.values());
    pageContext.setAttribute("foodTypes", FoodType.values());
    pageContext.setAttribute("transportTypes", TransportType.values());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Tour</title>
    <style>
        body {
            background-color: #f5f5f5;
            padding: 2px;
            display: flex;
            flex-direction: column;
        }
        .form{
            max-width: 400px;
            padding: 20px;
            margin: 0 auto;
            background-color: #fff;
        }
        .input-text{
            margin-top: 5px;
            margin-bottom: 5px;
        }
        .input-text-small{
            width: 60px;
        }
        .div-center{
            text-align: center;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        .div-saved{
            color: crimson;
            margin-top: 5px;
            text-align: center;
        }
    </style>
    <script>
        function chooseTour(radio) {
            var elemdivinfo = document.getElementById('div-info');
            var elemsaved = document.getElementById('div-saved');
            var elemrest= document.getElementById('div-rest');
            if (radio.value == null)
            {
                elemdivinfo.style.display = 'none';
                elemsaved.style.display = 'block';
                document.getElementById('save-button').disabled = true;
            }
            else
            {
                document.getElementById('save-button').disabled = false;
                elemdivinfo.style.display = 'block';
                elemsaved.style.display = 'none';
                if (radio.value === 'REST')
                {
                    elemrest.style.display = 'block';
                }
            }
        }
    </script>
</head>
<body>
<form class="form" method="POST" action="${pageContext.request.contextPath}/add">
    <div class="div-center" >
        <h3>Новый тур</h3>
    </div>
    <div>
        <c:forEach items="${tourTypes}" var="tourType" >
            <input class="input-text" type="radio" name="radioTourType" onclick="chooseTour(this);" value=${tourType.name()}> ${TourType.getName(tourType.name())}
        </c:forEach>
    </div>
    <div id="div-info" class="div-center"  style="display: none">
        <label>Дата отправления:
            <input class="input-text" type="date" name="calendar"> <br />
        </label>
        <div id="div-rest" style="display: none">
            <label>Страна:
                <input class="input-text" type="text" name="country" ><br />
            </label>
            <label>Курорт:
                <input class="input-text" type="text" name="resort" ><br />
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
                <c:forEach items = "${foodTypes}" var = "foodtype" >
                    <option value = ${foodtype.name()} >
                            ${FoodType.getFoodTypeFullName(foodtype)}
                    </option>
                </c:forEach>
            </select><br />
        </label>
        <div>
            <label>Тип транспорта: </Br>
                <c:forEach items="${transportTypes}" var="transportType">
                    <input class="input-text" type="radio" name="transportType" value=${transportType.name()}> ${TransportType.getName(transportType.name())}
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