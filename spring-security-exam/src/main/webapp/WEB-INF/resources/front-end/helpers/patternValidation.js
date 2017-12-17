$(document).ready(function () {


    let EMAIL_REGEXP       = new RegExp("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")
    let PASSWORD_REGEXP    = new RegExp("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    let MOBILE_PHONE_REGEXP = new RegExp("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")

    let checkEmail    = $('#registrationEmail')
    let checkPass     = $('#registrationPassword')
    let checkPhone    = $('#registrationPhone')
    let checkPassConf = $('#passwordConfirm')
    let regSubmit     = $('#regSubmit')


    checkEmail.blur(function () {
       if (!(EMAIL_REGEXP.test(this.value))) {
           this.classList.add("has-error")
           this.classList.remove("has-success")
           this.append('<p> Wrong email </p>')
       } else {
           this.classList.add('has-success')
           this.classList.remove("has-error")
       }
    })

    checkPass.blur(function () {
        if (!(PASSWORD_REGEXP.test(this.value))) {
            this.classList.add("has-error")
            this.classList.remove("has-success")
            this.append('<p> Wrong password </p>')
        } else {
            this.classList.add('has-success')
            this.classList.remove("has-error")
        }
    })

    checkPhone.blur(function () {
        if (!(MOBILE_PHONE_REGEXP.test(this.value))) {
            this.classList.add("has-error")
            this.classList.remove("has-success")
            this.append('<p> Wrong phone </p>')
        } else {
            this.classList.add('has-success')
            this.classList.remove("has-error")
        }
    })

    checkPassConf.blur(function () {
        if(this.value !== checkPass.val()){
            this.classList.add("has-error")
            this.classList.remove("has-success")
            this.append('<p> Passwords don\'t match </p>')
        } else {
            this.classList.add('has-success')
            this.classList.remove("has-error")
        }
    })

})