<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true"%>

<html>
<head>
    <%--<meta name="_csrf" content="${_csrf.token}"/>--%>
    <%--<!-- default header name is X-CSRF-TOKEN -->--%>
    <%--<meta name="_csrf_name" content="${_csrf.parameterName}"/>--%>
    <%--<!-- ... -->--%>

    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- ... -->

    <title>Registration</title>
    <script  src="../resources/vendor/js/jquery-3.2.1.js"></script>
    <script  src="../resources/vendor/js/underscore.js"></script>
    <script src="../resources/front-end/csrfHelper/ajaxCsrf.js"></script>
    <script src="../resources/front-end/User/registrationHandler.js"></script>
</head>
<body>
<form id="regForm">

    <label for="registrationName">Login</label>
    <input type="text" min="1" max="32" id="registrationName">

    <label for="registrationPassword">Password</label>
    <input type="password" min="1" max="32" id="registrationPassword">

    <label for="passwordConfirm">Password Confirm</label>
    <input type="password" min="1" max="32" id="passwordConfirm">

    <label for="registrationEmail">Email address</label>
    <input type="text" min="1" max="32" id="registrationEmail">

    <label for="registrationPhone">Contact number</label>
    <input type="text" min="1" max="10" id="registrationPhone">

    <button type="submit">Register</button>
</form>
</body>
</html>