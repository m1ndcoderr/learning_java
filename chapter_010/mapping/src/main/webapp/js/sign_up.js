// Makes sign up :
$(document).on('click', '#sign_up', function () {
    $.ajax('../signup', {
        method: 'post',
        data: {
            name: $('#name').val(),
            password: $('#password').val(),
            email: $('#email').val(),
            phone: $('#phone').val(),
            url: $('#url').val()
        },
        success: function (responseText) {
            if (responseText == "success") {
                $('#positive_message').show();
                setTimeout(function () {
                    window.location.href = "../html/basic.html";
                }, 2000);

            }
            if (responseText == "null_data") {
                $('#negative_message').show();
            }
        }
    });
});