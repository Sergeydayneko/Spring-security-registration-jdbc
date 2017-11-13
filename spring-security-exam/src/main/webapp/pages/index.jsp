<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Spring Security</title>
</head>
<body>

<div class="container">

    <div class="jumbotron" style="margin-top: 20px;">
        <h1>Dayneko Security #1</h1>
        <p class="lead">Simple Spring Security app</p>
        <sec:authorize access="!isAuthenticated()">
            <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Enter here</a></p>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <p>Ваш логин: <sec:authentication property="principal.username" /></p>
            <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Log out</a></p>
            <p><a class="btn btn-lg btn-info" href="<c:url value="/userPage" />" role="button">permission USER</a></p>
            <p><a class="btn btn-lg btn-info" href="<c:url value="/adminPage" />" role="button">permission ADMIN</a></p>
        </sec:authorize>
    </div>

</div>
<%--Vendor--%>
<link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
</body>
</html>
