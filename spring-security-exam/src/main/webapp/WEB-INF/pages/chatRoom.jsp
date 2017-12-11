<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>

<html>
<head>
    <title>Title</title>
    <script  src="../resources/vendor/js/jquery-3.2.1.js"></script>
    <script  src="../resources/vendor/js/underscore.js"></script>
    <script  src="../resources/front-end/Chat/socketConnection.js"></script>
    <script src="../resources/front-end/Chat/messageHandler.js"></script>

</head>
<body>

<div class="wraper">

    <div id="messageArea"></div>

    <div class="messageinputer">
        <textarea spellcheck="true" name="inputPanel" id="messageinput" class="messageInput" placeholder="Введите Ваше сообщение..." rows="5" cols="100" autofocus></textarea>
        <input class="submitButton" onclick="sendMessage();"  type="submit" value="Отправить">
    </div>

    <input  type="hidden" id="username" value="${username}"/>
    <input  type="hidden" id="userId" value="${user_id}"/>

</div>
</body>
</html>