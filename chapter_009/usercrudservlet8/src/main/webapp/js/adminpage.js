/**
 *
 *
 * FUNCTIONS FOR ADMIN ACTIONS on adminpage.html
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

// Show create user form.

$(document).on('click', '#1', function () {
    hideForms();
    $(document.getElementById('box-1')).show();
});

// Function of submit button. Creates new user.

$(document).on('click', '#createUser', function () {
    $.ajax('../createuser', {
        method: 'post',
        data: {
            username: $('#cr_username').val(), login: $('#cr_login').val(), email: $('#cr_email').val(),
            role_id: $('#cr_role_id').val(), country: $('#cr_country').val(), city: $('#cr_city').val()
        }
    });
    hideForms();
});

// Create Role button.

$(document).on('click', '#2', function () {
    hideForms();
    $(document.getElementById('box-2')).show();
});

// Create Role submit function:

$(document).on('click', '#createRole', function () {
    $.ajax('../createrole', {
        method: "post",
        data: {rolename: $('#rlname').val()},
        success: function (text) {
            if (text == 'adminpage') {
                location.href = "../html/adminpage.html"
            }
        }
    });
});

// Edit user form.

$(document).on('click', '#3', function () {
    hideForms();
    $(document.getElementById('box-3')).show();
});

// Edits user using data typed in form.

$(document).on('click', '#editUser', function () {
    $.ajax('../edituser', {
        method: 'post',
        data: {
            username: $('#ed_username').val(), login: $('#ed_login').val(), email: $('#ed_email').val(),
            role_id: $('#ed_role_id').val(), country: $('#ed_country').val(), city: $('#ed_city').val()
        },
        success: function (text) {
            if (text == 'adminpage') {
                location.href = "../html/adminpage.html"
            }
            if (text == 'error') {
                location.href = "../html/error.html"
            }
        }
    });
});

// Shows edit role form.

$(document).on('click', '#4', function () {
    hideForms();
    $(document.getElementById('box-4')).show();
});

// Create Role submit function:

$(document).on('click', '#editRole', function () {
    $.ajax('../editrole', {
        method: "post",
        data: {rolename: $('#new_rolename').val(), role_id: $('#role_id_to_edit')},
        success: function (text) {
            if (text == 'adminpage') {
                location.href = "../html/adminpage.html"
            } else {
                location.href = "../html/error.html"
            }
        }
    });
});

// Shows delete user form.

$(document).on('click', '#5', function () {
    hideForms();
    $(document.getElementById('box-5')).show();
});

// Function of submit button.
$(document).on('click', '#deleteUser', function () {
    $.ajax('../deleteuser', {
        method: "post",
        data: {username: $('#del_username').val(), login: $('#del_login').val()},
        success: function (text) {
            if (text == 'adminpage') {
                location.href = "../html/adminpage.html"
            }
            if (text == 'error') {
                location.href = "../html/error.html"
            }
        }
    });
});

// Shows delete role form.
$(document).on('click', '#6', function () {
    hideForms();
    $(document.getElementById('box-6')).show();
});

// Deleting of role function.

$(document).on('click', '#deleteRole', function () {
    $.ajax('../deleterole', {
        method: "post",
        data: {role_id: $('#del_role_id').val()},
        success: function (text) {
            if (text == 'adminpage') {
                location.href = "../html/adminpage.html"
            }
            if (text == 'error') {
                location.href = "../html/error.html"
            }
        }
    });
});

// Show All users button below.

$(document).on('click', '#7', function () {
    hideForms();
    showTable();
    $(document.getElementById('box-7')).show();
});

// Shows all users in database.

function showTable() {
    $('#box-7').empty();
    $.get('../showallusers', function (responseText) {
        $("#box-7").html(responseText);
        setTableStyle();
    });
}


// Sets user table style.

function setTableStyle() {
    $("table").addClass("table");
    $("table").addClass("center_table");
    $("th, td").addClass("th, td");
}


// Shows all roles.

$(document).on('click', '#8', function () {
    hideForms();
    showRoles();
    $(document.getElementById('box-8')).show();
});

// Shows table with all roles from database.

function showRoles() {
    $('#box-8').empty();
    $.get('../showallroles', function (responseText) {
        $("#box-8").html(responseText);
        setTableStyle();
    });
}

// Hides all forms on the page.

function hideForms() {
    for (var i = 1; i <= 8; i++) {
        $(document.getElementById('box-' + i)).hide();
    }
}
