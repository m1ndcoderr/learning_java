// Makes sign in if you have an account:
$(document).on('click', '#sign_in', function () {
    $.ajax('../signin', {
        method: 'post',
        data: {name: $('#name').val(), password: $('#password').val()},
        success: function (responseText) {
            if (responseText == "positive") {
                $('#positive_message').show();
                setTimeout(function () {
                    window.location.href = "../html/basic.html";
                }, 2000);

            }
            if (responseText == "negative") {
                $('#negative_message').show();
            }
        }
    });
});