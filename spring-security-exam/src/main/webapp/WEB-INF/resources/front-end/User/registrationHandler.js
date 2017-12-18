$(document).ready(function () {

    $('#regForm').submit(function (e) {
        e.preventDefault()

        let login           = $('#registrationName').val()
        let password        = $('#registrationPassword').val()
        let passwordConfirm = $('#passwordConfirm').val()
        let email           = $('#registrationEmail').val()
        let phone           = $('#registrationPhone').val()

        let userJSON = {
            login           : login,
            password        : password,
            passwordConfirm : passwordConfirm,
            email           : email,
            phone           : phone
        }

        $.post(`registerProcess`, userJSON, function (data) {
            document.location.href = 'http://localhost:8080/login'
        }).fail(function (error) {
            //TODO Сделать обработчик поступивших ошибок
            console.log(error.responseJSON)
        })
    })

    function enableSubmit(e) {
        debugger
    }

})