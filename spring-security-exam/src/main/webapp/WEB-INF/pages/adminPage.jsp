<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page session="true"%>

<html>
<head>
    <title>Admin Page</title>
</head>
<body>

<div class="text-info lead ">
    <h3>You are now on ADMIN_ROLE page</h3>
</div>
<%-- Form for displaying logName--%>
<div class="container text-success">
    <h1>Welcome, <sec:authentication property="principal.username" /></h1>
</div>

<%--Vendor--%>
<link href="<c:url value="../resources/vendor/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="../resources/vendor/css/jumbotron-narrow.css" />" rel="stylesheet">
</body>
</html>
