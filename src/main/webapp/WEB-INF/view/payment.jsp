
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring_form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Оплата заказа</title>
    <link type="text/css" rel="stylesheet" href="/resources/css/common.css" />
    <link type="text/css" rel="stylesheet" href="/resources/css/login.css" />
</head>
<body>
    <spring_form:form cssClass="form" method="POST" action="/booking/addPayment" modelAttribute="payment">
        <div class="content">
            <div>
                <h3 class="div-center">Заказ № ${payment.booking.orderNumber}</h3>
            </div>
            <div>
                <spring_form:hidden path="booking.id" value="${payment.booking.id}" />
                <spring_form:hidden path="sum" value="${payment.booking.costWithSale}" />
            </div>
            <div>Сумма к оплате: ${payment.booking.costWithSale}</div>
            <br/>
            <div>
                <spring_form:label path="payer">ФИО плательщика</spring_form:label>
                <br/>
                <spring_form:input class="input-text" path="payer"/>
            </div>
            <div>
                <spring_form:label path="cardNumber">Номер карт-счета</spring_form:label>
                <br/>
                <spring_form:input class="input-text" path="cardNumber"/>
            </div>
            <div>
                <input class="input-text" type="submit" value="Оплатить"/>
            </div>
        </div>
    </spring_form:form>
</body>
</html>
