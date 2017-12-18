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
    <link rel="stylesheet" href="../resources/styles/styles.css">
    <link rel="stylesheet" href="../resources/vendor/css/bootstrap.min.css">

</head>
<body>
<div class="container" style="width: 300px;">
    <form id="regForm">

        <h2 class="form-signin-heading">Registration page :)</h2>

        <div class="field form-group">
            <label for="registrationName">Login</label>
            <input
                    type    = "text"
                    min     = "1"
                    max     = "32"
                    id      = "registrationName"
                    class   = "form-control"
                    required
                    onblur=""
            >
        </div>

        <div class="field form-group">
            <label for="registrationPassword">Password</label>
            <input
                    type    = "password"
                    min     = "1"
                    max     = "32"
                    id      = "registrationPassword"
                    class   = "form-control"
                    required
            >
        </div>

        <div class="field form-group">
            <label for="passwordConfirm">Password Confirm</label>
            <input
                    type    = "password"
                    min     = "1"
                    max     = "32"
                    id      = "passwordConfirm"
                    class   = "form-control"
                    required
            >
        </div>

        <div class="field form-group">
            <label for="registrationEmail">Email address</label>
            <input
                    type        = "text"
                    min         = "1"
                    max         = "32"
                    id          = "registrationEmail"
                    placeholder = "example@mail.ru"
                    class       = "form-control"
                    required
            >
        </div>

        <div class="field form-group">
            <label for="registrationPhone">Contact number</label>
            <input
                    type    = "text"
                    id      = "registrationPhone"
                    min     = "3"
                    max     = "12"
                    class   = "form-control"
                    required
            >
        </div>

        <button id="regSubmit" disabled="disabled" class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    </form>
</div>
</body>
</html>