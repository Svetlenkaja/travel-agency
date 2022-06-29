
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Горящий тур!!!</title>
  <link type="text/css" rel="stylesheet" href="/resources/css/common.css" />
  <link type="text/css" rel="stylesheet" href="/resources/css/hotTour.css" />
</head>
<body>
  <div class="content">
    <jsp:include page="_header.jsp" />
    <jsp:include page="_menu.jsp" />
  </div>
  <spring_form:form cssClass="form" method="POST" action="/tours/hotTour" modelAttribute="tour">
    <div class="div-center">
      <h2 >Тур № ${tour.id}</h2>
    </div>
    <div id="div-info" class="div-center" >
      <spring_form:hidden path="id" value="${id}" />
      <spring_form:label path="discount"><b>Скидка</b></spring_form:label>
      <spring_form:select path="discount" >
        <c:forEach items = "${discounts}" var = "discount" >
          <spring_form:option value="${discount.getCode()}" label="${discount.getCode()} %"/>
        </c:forEach>
      </spring_form:select>
    </div>
    <br />
    <div class="div-center">
      <button style="color: crimson; margin-top: 5px;" type="submit" value="Submit">Сохранить</button>
      <button onclick="location.href='home'">Назад</button>
    </div>
  </spring_form:form>
</body>
</html>

