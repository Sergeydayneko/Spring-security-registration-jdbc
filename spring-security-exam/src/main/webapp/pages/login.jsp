<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Spring Security</title>
</head>
<body>
<div class="container" style="width: 300px;">

    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Sign in here</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email or Login" autofocus>
        <input type="password" class="form-control" name="j_password" placeholder="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Enter</button>
    </form>

</div>
<%--Vendor--%>
<link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/pages/css/signin.css" />" rel="stylesheet">
</body>
</html>
