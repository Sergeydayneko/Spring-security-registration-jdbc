<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Spring Security</title>
</head>
<body>
<div class="container" style="width: 300px;">

    <form method="post" action="j_spring_security_check" method='POST'>
        <h2 class="form-signin-heading">Sign in here</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email or Login" autofocus>
        <input type="password" class="form-control" name="j_password" placeholder="Password">

        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

        <button class="btn btn-lg btn-primary btn-block" type="submit">Enter</button>
    </form>

    <p class="p">У меня пока нет аккаунта.</p>
    <p class="link"> Хочу <a href='/registration'>зарегистрироваться!</a></p>

</div>
<%--Vendor--%>
<link href="<c:url value="../resources/vendor/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="../resources/vendor/css/signin.css" />" rel="stylesheet">
</body>
</html>
