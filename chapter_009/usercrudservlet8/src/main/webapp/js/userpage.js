/**
 *
 *
 * FUNCTIONS FOR USER ACTIONS on userpage.html
 *
 *
 */

// Shows message.

$(function () {
    $('.required-icon').tooltip({
        placement: 'left',
        title: 'Required field'
    });
});

// Types user's name in <H1> section.

window.onload = function () {
    $.get('../typeusername', function (responseText) {
        $("#user_title").html(responseText);
    });
};

// Log out form. "Yes" button (cleans session out, redirect to signin.html).

$(document).on('click', '#log_out_yes', function () {
    $.ajax('../logout', {
        method: "post",
        success: function (text) {
            if (text == 'signin') {
                location.href = "../html/signin.html"
            }
            if (text == "error") {
                location.href = "../html/error.html"
            }
        }
    });
});

// Log out form. "No" button (hides form).

$(document).on('click', '#log_out_no', function () {
    $(document.getElementsById('box-4')).hide();
});

// Hides all forms on the page.

function hideForms() {
    for (var i = 1; i <= 4; i++) {
        $(document.getElementById('box-' + i)).hide();
    }
}

// Shows edit user form.

$(document).on('click', '#1', function () {
    hideForms();
    $(document.getElementById('box-1')).show();
});

// Edits user by user.

$(document).on('click', '#user_edit_account', function () {
    $.ajax('../edituser', {
        method: 'post',
        data: {
            username: $('#us_ed_username').val(), email: $('#us_ed_email').val(),
            country: $('#us_ed_country').val(), city: $('#us_ed_city').val()
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
});

// Shows delete user form.

$(document).on('click', '#2', function () {
    hideForms();
    $(document.getElementById('box-2')).show();
});

// Deleting user's account. Redirect to signin.html or to error.html if smth goes wrong.

$(document).on('click', '#us_del_account_yes', function () {
    $.ajax('../deleteuser', {
        method: 'post',
        data: {
            username: $('#us_delete_acc_username').val(),
            login: $('#us_delete_acc_login').val()
        },
        success: function (text) {
            if (text == 'signin') {
                location.href = "../html/signin.html"
            }
            if (text == 'error') {
                location.href = "../html/error.html"
            }
        }
    });
});

// Hides delete form.

$(document).on('click', '#us_del_account_no', function () {
    $(document.getElementById('box-2')).hide();
});

// Shows all data about user form.

$(document).on('click', '#3', function () {
    hideForms();
    $.get('../typepersonaldata', function (responseText) {
        $("#personal_data").html(responseText)
    });
    $(document.getElementById('box-3')).show();
});

// Shows log out user form.

$(document).on('click', '#4', function () {
    hideForms();
    $(document.getElementById('box-4')).show();
});