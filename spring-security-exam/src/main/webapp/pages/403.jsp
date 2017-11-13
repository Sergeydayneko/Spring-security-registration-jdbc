<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <title>Permission error page</title>
</head>
<body>

<h2>${msg}</h2>

<p><a class="btn btn-lg btn-info" href="<c:url value="/index" />" role="button">Return back</a></p>


<link href="<c:url value="/pages/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/pages/css/jumbotron-narrow.css" />" rel="stylesheet">
</body>
</html>
