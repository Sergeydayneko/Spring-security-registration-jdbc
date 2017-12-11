<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page session="true"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>
<form:form id="regForm" modelAttribute="User" action="registerProcess" method="post">
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

    <label for="registrationName">?????</label>
    <input type="text" min="1" max="32" id="registrationName">

    <label for="registrationPassword">??????</label>
    <input type="password" min="1" max="32" id="registrationPassword">

    <label for="passwordConfirm">????????????? ??????</label>
    <input type="password" min="1" max="32" id="passwordConfirm">

    <label for="registrationEmail">?????</label>
    <input type="text" min="1" max="32" id="registrationEmail">

    <label for="registrationPhone">?????????? ???????</label>
    <input type="number" min="1" max="10" id="registrationPhone">



    <table align="center">
        <tr>
            <td>
                <form:label path="username">Username</form:label>
            </td>
            <td>
                <form:input path="username" name="username" id="username" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password</form:label>
            </td>
            <td>
                <form:password path="password" name="password" id="password" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">Email</form:label>
            </td>
            <td>
                <form:input path="email" name="email" id="email" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="phone">Phone</form:label>
            </td>
            <td>
                <form:input path="phone" name="phone" id="phone" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button id="register" name="register">Register</form:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href="/">Home</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>