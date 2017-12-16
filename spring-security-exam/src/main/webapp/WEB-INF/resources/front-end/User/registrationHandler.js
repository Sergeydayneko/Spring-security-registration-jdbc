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
            debugger
            //TODO Сделать через промисы, обработать ошибку, вывод информации
            //TODO Сделать валидацию на фронт части
            console.log(data)
        })

    })
})