// Makes sign in if you have an account:

function makeLogin() {
    $.ajax('../signin', {
        method: 'post',
        data: {login: $('#login').val(), username: $('#username').val()},
        success: function (text) {
            if (text == 'adminpage') {
                location.href = "../html/adminpage.html"
            }
            if (text == 'userpage') {
                location.href = "../html/userpage.html"
            }
            if (text == 'error') {
                location.href = "../html/error.html"
            }
        }
    });
}

// Makes sign in with creation of new account:

function makeSignUp() {
    $.ajax('../signup', {
        method: 'post',
        data: {
            username_sign: $('#username_sign').val(),
            login_sign: $('#login_sign').val(),
            email_sign: $('#email_sign').val()
        },
        success: function (text) {
            if (text == 'userpage') {
                location.href = "../html/userpage.html"
            }
            if (text == 'error') {
                location.href = "../html/error.html"
            }
        }
    });
}


// Opens login part of form:

function openLogin() {
    document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
    document.querySelector('.cont_form_login').style.display = "block";
    document.querySelector('.cont_form_sign_up').style.opacity = "0";

    setTimeout(function () {
        document.querySelector('.cont_form_login').style.opacity = "1";
    }, 400);

    setTimeout(function () {
        document.querySelector('.cont_form_sign_up').style.display = "none";
    }, 200);
}


// Opens sign up part of form:

function openSignup(at) {
    document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
    document.querySelector('.cont_form_sign_up').style.display = "block";
    document.querySelector('.cont_form_login').style.opacity = "0";

    setTimeout(function () {
        document.querySelector('.cont_form_sign_up').style.opacity = "1";
    }, 100);

    setTimeout(function () {
        document.querySelector('.cont_form_login').style.display = "none";
    }, 400);


}


// Closes currently opened part of form:

function exitForms() {

    document.querySelector('.cont_forms').className = "cont_forms";
    document.querySelector('.cont_form_sign_up').style.opacity = "0";
    document.querySelector('.cont_form_login').style.opacity = "0";

    setTimeout(function () {
        document.querySelector('.cont_form_sign_up').style.display = "none";
        document.querySelector('.cont_form_login').style.display = "none";
    }, 500);

}
