<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true"%>

<html>
<head>
                <!--X-CSRF-TOKEN -->
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>Registration</title>
    <script  src="../resources/vendor/js/jquery-3.2.1.js"></script>
    <script  src="../resources/vendor/js/underscore.js"></script>
    <script src="../resources/front-end/helpers/ajaxCsrf.js"></script>
    <script src="../resources/front-end/User/registrationHandler.js"></script>
    <script src="../resources/front-end/helpers/inputProhibition.js"></script>
    <script src="../resources/front-end/helpers/patternValidation.js"></script>
</head>
<body>
<form id="regForm">

    <label for="registrationName">Login</label>
    <input
            type    = "text"
            min     = "1"
            max     = "32"
            id      = "registrationName"
    >

    <label for="registrationPassword">Password</label>
    <input
            type    = "password"
            min     = "1"
            max     = "32"
            id      = "registrationPassword"
    >

    <label for="passwordConfirm">Password Confirm</label>
    <input
            type    = "password"
            min     = "1"
            max     = "32"
            id      = "passwordConfirm"
    >

    <label for="registrationEmail">Email address</label>
    <input
            type    = "text"
            min     = "1"
            max     = "32"
            id      = "registrationEmail"
    >

    <label for="registrationPhone">Contact number</label>
    <input
            type    = "text"
            id      = "registrationPhone"
            min     = "3"
            max     = "12"
    >

    <button id="regSubmit" type="submit">Register</button>
</form>
</body>
</html>