<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
</head>
<body>

<spring:message code="start.language" /> : <a href="?language=en"><spring:message code="start.EN" /> </a> | <a href="?language=ru"><spring:message code="start.RU" /></a>




<%--<a href="?language=en">English </a> | <a href="?language=de">German </a>--%>
<%--<h3> <spring:message code="user.title" /></h3>--%>

</body>
</html>