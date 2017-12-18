$(document).ready(function () {

    let EMAIL_REGEXP        = new RegExp("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")
    let PASSWORD_REGEXP     = new RegExp("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    let MOBILE_PHONE_REGEXP = new RegExp("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")

    let checkEmail    = $('#registrationEmail')
    let checkPass     = $('#registrationPassword')
    let checkPhone    = $('#registrationPhone')
    let checkPassConf = $('#passwordConfirm')
    let regSubmit     = $('#regSubmit')
    let login         = $('#registrationName')

    let statuses = [false, false, false, false]

    checkEmail.blur(function () {
       if (!(EMAIL_REGEXP.test(this.value))) {
           this.classList.add("has-error")
           this.classList.remove("has-success")
           this.append('<p> Wrong email </p>')
           statuses[0] = false
       } else {
           this.classList.add('has-success')
           this.classList.remove("has-error")
           statuses[0] = true
       }
    })

    checkPass.blur(function () {
        if (!(PASSWORD_REGEXP.test(this.value))) {
            this.classList.add("has-error")
            this.classList.remove("has-success")
            this.append('<p> Wrong password </p>')
            statuses[1] = false
        } else {
            this.classList.add('has-success')
            this.classList.remove("has-error")
            statuses[1] = true
        }
    })

    checkPhone.blur(function () {
        if (!(MOBILE_PHONE_REGEXP.test(this.value))) {
            this.classList.add("has-error")
            this.classList.remove("has-success")
            this.append('<p> Wrong phone </p>')
            statuses[2] = false
        } else {
            this.classList.add('has-success')
            this.classList.remove("has-error")
            statuses[2] = true
        }
    })

    checkPassConf.blur(function () {
        if(this.value !== checkPass.val()){
            this.classList.add("has-error")
            this.classList.remove("has-success")
            this.append('<p> Passwords don\'t match </p>')
            statuses[3] = false
        } else {
            this.classList.add('has-success')
            this.classList.remove("has-error")
            statuses[3] = true
        }
    })

    checkPhone.blur(function () {
        if (!(MOBILE_PHONE_REGEXP.test(this.value))) {
            this.classList.add("has-error")
            this.classList.remove("has-success")
            this.append('<p> Wrong phone </p>')
            statuses[2] = false
        } else {
            this.classList.add('has-success')
            this.classList.remove("has-error")
            statuses[2] = true
        }
    })

    //TODO обработать проверка с сервера на наличие имени
    login.blur(function () {
        if(this.value === ''){
            this.classList.add("has-error")
            this.classList.remove("has-success")
            this.append('<p> Invalid login name</p>')
            statuses[4] = false
        } else {
            this.classList.add('has-success')
            this.classList.remove("has-error")
            statuses[4] = true
        }
    })

    $('#regForm').change(function () {
        setTimeout(function () {
            if (statuses.indexOf(false) >= 0) {
                $('#regSubmit').prop('disabled', true)
            } else {
                $('#regSubmit').prop('disabled', false)
            }
        }, 100)
    })

})