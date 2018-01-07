<%@ page contentType="text/html; charset=Cp1251" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
    <title>Spring Security</title>
</head>
<body>
<spring:message code="start.language" /> : <a href="?language=en"><spring:message code="start.EN" /> </a> | <a href="?language=ru"><spring:message code="start.RU" /></a>

<div class="container">
    <div class="jumbotron" style="margin-top: 20px;">

        <h1>Coding 4ever</h1>
        <p class="lead">Simple Spring Security app</p>
        <sec:authorize access="!isAuthenticated()">
            <p>
                <a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">
                    <spring:message code="start.enter" />
                </a>
            </p>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <p>Ваш логин: <sec:authentication property="principal.username" /></p>
            <p><a class="btn btn-lg btn-danger" href="<c:url value="/login?logout" />" role="button">Log out</a></p>
            <p><a class="btn btn-lg btn-info" href="<c:url value="/userPage" />" role="button">permission USER</a></p>
            <p><a class="btn btn-lg btn-info" href="<c:url value="/adminPage" />" role="button">permission ADMIN</a></p>
            <p><a class="btn btn-lg btn-info" href="<c:url value="/chat" />" role="button">ENTER THE GLOBAL CHAT</a></p>
        </sec:authorize>
    </div>

</div>
<%--Vendor--%>
<link href="<c:url value="../resources/vendor/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="../resources/vendor/css/jumbotron-narrow.css" />" rel="stylesheet">
</body>
</html>